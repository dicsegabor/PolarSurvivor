package SwingMVC.Model;

import Exceptions.ItemNotFoundException;
import Mezo.*;
import Mozgathato.Eszkimo;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Mozgathato.Kutato;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.GameEventListener;
import SwingMVC.Eventhandling.Events.JatekvegeEvent;
import SwingMVC.Eventhandling.Events.KarakterKorvegeEvent;
import SwingMVC.Eventhandling.Events.KorvegeEvent;
import SwingMVC.Eventhandling.Events.UzenetEvent;
import Targy.Jelzofeny;
import Targy.Patron;
import Targy.Pisztoly;
import Targy.Targytipus;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Model {

    private ArrayList<Karakter> karakterek;
    private ArrayList<Mezo> mezok;
    private Jegesmedve jegesmedve;

    private static final int DEFAULT_MAP_WIDTH = 6;
    private static final int DEFAULT_MAP_HEIGHT = 5;

    public Model(){

        karakterek = new ArrayList<>();
        mezok = new ArrayList<>();
        loadDefaultMap();

        addGameEventListener();
    }

    public Karakter getNextKarakter(Karakter karakter){

        if(karakterek.indexOf(karakter) < karakterek.size() - 1)
            return karakterek.get(karakterek.indexOf(karakter) + 1);

        else{

            Controller.getInstance().korvege(new KorvegeEvent(this));
            return karakterek.get(0);
        }
    }

    public void loadDefaultMap() {

        karakterek.clear();
        mezok.clear();
        jegesmedve = null;

        File text = new File("src\\SwingMVC\\Model\\Map.txt");

        Scanner scanner = null;
        try { scanner = new Scanner(text); }
        catch (FileNotFoundException e) { System.out.println("A '" + text + "fájl nem található!"); }

        Mezo[][] palya = new Mezo[DEFAULT_MAP_HEIGHT][DEFAULT_MAP_WIDTH];

        if(scanner == null)
            return;

        while(scanner.hasNextLine()){
            for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++) {
                for (int j = 0; j < DEFAULT_MAP_WIDTH ; j++) {

                    String tmp = scanner.nextLine();
                    String[] sor = tmp.split("\\t");

                    switch (sor[0]) {

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

        setNeighbours(palya);

        Karakter karakter1 = new Eszkimo(palya[1][2]);
        palya[1][2].addKarakter(karakter1);
        karakterek.add(karakter1);

        Karakter karakter2 = new Kutato(palya[3][2]);
        palya[3][2].addKarakter(karakter2);
        karakterek.add(karakter2);

        jegesmedve = new Jegesmedve(palya[2][4]);
        palya[2][4].befogad(jegesmedve);

        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++)
            mezok.addAll(Arrays.asList(palya[i]).subList(0, DEFAULT_MAP_WIDTH));
    }

    private void setNeighbours(Mezo[][] palya){

        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++)
            for (int j = 0; j < DEFAULT_MAP_WIDTH ; j++)
                for (int k = 0; k < DEFAULT_MAP_HEIGHT; k++)
                    for (int l = 0; l < DEFAULT_MAP_WIDTH; l++)
                        if(Math.abs(i-k) == 0 && Math.abs(j-l) == 1 || Math.abs(i-k) == 1 && Math.abs(j-l) == 0)
                            palya[i][j].setSzomszed(palya[k][l]);
    }

    public void generateRandomMap(){

        mezok.clear();
        karakterek.clear();
        jegesmedve = null;

        ArrayList<Mezo> generatedFields = generateFields(1, 1, true);

        Mezo[][] board = new Mezo[DEFAULT_MAP_HEIGHT][DEFAULT_MAP_WIDTH];
        fillBoardRandomly(generatedFields, board);
        setNeighbours(board);

        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++)
            mezok.addAll(Arrays.asList(board[i]).subList(0, DEFAULT_MAP_WIDTH));
    }

    private ArrayList<Mezo> generateFields(int researcherNumber, int eskimoNumber, boolean polarBear ) {

        ArrayList<Mezo> fields = new ArrayList<>(generateInitFields(researcherNumber, eskimoNumber, polarBear));

        RandomGenerator LYUK = new RandomGenerator(20);
        RandomGenerator INSTABIL = new RandomGenerator(30);
        RandomGenerator STABIL = new RandomGenerator(50);

        RandomGenerator LYUK_FEDETTSEG = new RandomGenerator(30);
        RandomGenerator TARGY = new RandomGenerator(60);

        boolean full = false;

        int maxCapacity = researcherNumber + eskimoNumber + 1;

        while (!full){

            if(LYUK.getJudgment()) {

                fields.add(new Lyuk(LYUK_FEDETTSEG.getJudgment()));
                full = fields.size() == DEFAULT_MAP_HEIGHT * DEFAULT_MAP_WIDTH;
            }

           if(INSTABIL.getJudgment() && !full){

               fields.add(new InstabilJegtabla(true, maxCapacity, TARGY.getJudgment()));
               full = fields.size() == DEFAULT_MAP_HEIGHT * DEFAULT_MAP_WIDTH;
            }

            if(STABIL.getJudgment() && !full){

                fields.add(new StabilJegtabla(true, TARGY.getJudgment()));
                full = fields.size() == DEFAULT_MAP_HEIGHT * DEFAULT_MAP_WIDTH;
            }
        }

        return fields;
    }

    private ArrayList<Mezo> generateInitFields(int researcherNumber, int eskimoNumber, boolean polarBear) {

        ArrayList<Mezo> fields = new ArrayList<>();

        for(int i = 0; i < researcherNumber; i++){
            StabilJegtabla ice = new StabilJegtabla();
            Kutato researcher = new Kutato(ice);
            karakterek.add(researcher);
            ice.befogad(researcher);
            fields.add(ice);
        }

        for(int i = 0; i < eskimoNumber; i++){
            StabilJegtabla ice = new StabilJegtabla();
            Eszkimo eskimo = new Eszkimo(ice);
            karakterek.add(eskimo);
            ice.befogad(eskimo);
            fields.add(ice);
        }

        StabilJegtabla ice = new StabilJegtabla();
        Jegesmedve polarBearAnimal = new Jegesmedve(ice);
        jegesmedve = polarBearAnimal;
        ice.befogad(polarBearAnimal);
        fields.add(ice);

        StabilJegtabla flareGunIce = new StabilJegtabla();
        flareGunIce.setTargy(new Pisztoly());
        fields.add(flareGunIce);

        StabilJegtabla cartridgeIce = new StabilJegtabla();
        cartridgeIce.setTargy(new Patron());
        fields.add(cartridgeIce);

        StabilJegtabla flareIce = new StabilJegtabla();
        flareIce.setTargy(new Jelzofeny());
        fields.add(flareIce);

        return fields;
    }

    private void fillBoardRandomly(ArrayList<Mezo> mezok, Mezo[][] palya){

        ArrayList<Point> freeCoords = new ArrayList<>();
        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++)
            for (int j = 0; j < DEFAULT_MAP_WIDTH; j++)
                freeCoords.add(new Point(i, j));

        for (Mezo m : mezok){

            Point coord = getRandomCoords(freeCoords);
            palya[coord.x][coord.y] = m;
        }
    }

    private Point getRandomCoords(ArrayList<Point> coords){

        Point coord = coords.get(new Random().nextInt(coords.size()));
        coords.remove(coord);

        return coord;
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
        };

        Controller.getInstance().addGameEventListener(gameEventListener);
    }

    public void jegetNez(Kutato activeKarakter, Mezo mezo) {

        activeKarakter.jegetNez(mezo);
    }
}
