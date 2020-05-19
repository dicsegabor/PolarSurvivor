package SwingMVC.Model;

import Exceptions.ItemNotFoundException;
import Mezo.*;
import Mozgathato.Eszkimo;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Mozgathato.Kutato;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.GameEventListener;
import SwingMVC.Eventhandling.Events.*;
import Targy.Targytipus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * //model szintű megvalósítása a játék mezőinek, karaktereinek. ez még nem a grafikus megjelenítéssel foglalkozik
 */
public class Model {



    private ArrayList<Karakter> karakterek; // Karakterek listája
    private ArrayList<Mezo> mezok;     // Mezők listája, ide pakoljuk a létrehozott mezőket.
    private Jegesmedve jegesmedve;          // a jegesmedve

    private MapGenerator generator;   // mapgenerátor objektum

    public static final int DEFAULT_MAP_WIDTH = 6;
    public static final int DEFAULT_MAP_HEIGHT = 5;

    public Model(){ // konstruktor

        karakterek = new ArrayList<>();
        mezok = new ArrayList<>();

        generator = new MapGenerator(mezok, karakterek, jegesmedve);

        loadDefaultMap();  // alap pálya betöltáse.

        addGameEventListener(); // eventekre feliratkozás, hogy a játék tudja érzékelni a kör végét.
    }

    /**
     * egy soron következő karaktert ad vissza ez a függvény.kör végéhez kell
     * @param karakter : egy karakter.
     */
    public Karakter getNextKarakter(Karakter karakter){

        if(karakterek.indexOf(karakter) < karakterek.size() - 1)   // "karakterek" lista vizsgálásával.
            return karakterek.get(karakterek.indexOf(karakter) + 1);

        else{

            Controller.getInstance().korvege(new KorvegeEvent(this));
            return karakterek.get(0);
        }
    }

    /**
     *Függvény ami az alap pályát tölti be txt-ből.
     *
     */
    public void loadDefaultMap() {

        karakterek.clear();  //karakter lista ürítése
        mezok.clear();      //mezők lista ürítése
        jegesmedve = null;  // ez a txt-ből jön.

        URL path = getClass().getResource("Map.txt"); // txt-ből olvassuk be a pálya részeit

        Scanner scanner = null;
        try { scanner = new Scanner(path.openStream()); }
        catch (FileNotFoundException e) { System.out.println("A '" + path + "fájl nem található!"); } catch (IOException e) {
            e.printStackTrace();// rossz elérési útvonal lekezelése
        }

        Mezo[][] palya = new Mezo[DEFAULT_MAP_HEIGHT][DEFAULT_MAP_WIDTH];//mezőket tartalmazó tömb létrehozása

        if(scanner == null)
            return;

        while(scanner.hasNextLine()){
            for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++) {
                for (int j = 0; j < DEFAULT_MAP_WIDTH ; j++) {//txt-ből beolvasás

                    String tmp = scanner.nextLine();//következő sor
                    String[] sor = tmp.split("\\t");// részekre darabolás

                    switch (sor[0]) { // itt a sor tömb részeit annak megfelelően használjuk, hogy mit hozunk éppen létre az adott sorban.

                        case "LYUK":
                            if (0 == Integer.parseInt(sor[2]))
                                palya[i][j] = new Lyuk(false);

                            else
                                palya[i][j] = new Lyuk(true);

                            break;

                        case "STABIL":
                            StabilJegtabla stabil = new StabilJegtabla();

                            stabil.setHoreteg(Integer.parseInt(sor[2]));
                            stabil.setTargy(Targytipus.letrehoz(Targytipus.valueOf(sor[3])));
                            palya[i][j] = stabil;
                            break;

                        case "INSTABIL":
                            InstabilJegtabla instabil = new InstabilJegtabla(Integer.parseInt(sor[1]));
                            instabil.setHoreteg(Integer.parseInt(sor[2]));

                            if (!sor[3].equals("null"))
                                instabil.setTargy(Targytipus.letrehoz(Targytipus.valueOf(sor[3])));

                            palya[i][j] = instabil;
                            break;
                    }
                }
            }
        }

        MapGenerator.setNeighbours(palya); // szomszédsági vizsonyok beállítása

        Karakter karakter1 = new Eszkimo(palya[1][2]);
        palya[1][2].addKarakter(karakter1);
        karakterek.add(karakter1);

        Karakter karakter2 = new Kutato(palya[3][2]);//karakterek inicializálása, bepakoljuk őket a karakterek listába és a pályára rakjuk őket.
        palya[3][2].addKarakter(karakter2);
        karakterek.add(karakter2);

        jegesmedve = new Jegesmedve(palya[2][4]);
        palya[2][4].befogad(jegesmedve);// egy jegesmedve hozzáadása a játékhoz.

        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++)
            mezok.addAll(Arrays.asList(palya[i]).subList(0, DEFAULT_MAP_WIDTH));// beolvasott mezők
    }

    public void generateRandomMap(){

        generator.generateRandomMap();
    }

    public ArrayList<Mezo> getMezok() {

        return mezok;
    }

    public Mezo getMezo(int ID){

        return mezok.get(ID);
    }

    public Karakter getKarakter(int ID){

        return karakterek.get(ID);
    }

    public void lep(Karakter karakter, Mezo mezo){

        karakter.lep(mezo);
    }

    public void as(Karakter activeKarakter) {

        activeKarakter.as();
    }

    public void targyatFelvesz(Karakter activeKarakter) {
        activeKarakter.felvesz();
    }

    public void iglutEpit(Eszkimo activeKarakter) {
        activeKarakter.iglutEpit();
    }

    public void satratEpit(Karakter activeKarakter) {
        try {
            activeKarakter.keres(Targytipus.SATOR).hasznal(activeKarakter);
        } catch (ItemNotFoundException ignored) { }
    }

    public void osszeszerel(Karakter activeKarakter) {
        activeKarakter.kombinal();
    }

    private void addGameEventListener(){

        GameEventListener gameEventListener = new GameEventListener() {

            @Override
            public void karakterKorvege(KarakterKorvegeEvent event) {

            }

            @Override
            public void korvege(KorvegeEvent event) {

                for(Karakter k : karakterek)
                    k.munkatVisszaallit();

                for(Mezo m : mezok)
                    m.vihar();

                if(jegesmedve != null)
                    jegesmedve.lep(null);
            }

            @Override
            public void jatekVege(JatekvegeEvent event) {

            }

            @Override
            public void uzenetEvent(UzenetEvent event) {

            }

            @Override
            public void statusUpdate(KarakterStatusUpdateEvent event) {

            }
        };

        Controller.getInstance().addGameEventListener(gameEventListener);
    }

    public void jegetNez(Kutato activeKarakter, Mezo mezo) {

        activeKarakter.jegetNez(mezo);
    }
}
