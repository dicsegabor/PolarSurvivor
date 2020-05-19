package SwingMVC.Model;

import Mezo.*;
import Mozgathato.*;
import Targy.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MapGenerator {

    public static int researcherCount = 1;
    public static int eskimoCount = 1;
    public static boolean polarBear = true;

    public static int HOLE = 40;
    public static int UNSTABLE = 50;
    public static int STABLE = 100;
    public static int HOLE_COVERAGE = 30;
    public static int ITEM_CHANCE = 60;

    private ArrayList<Mezo> fields;
    private ArrayList<Karakter> characters;
    private Jegesmedve bear;
    /**
     * Feltöltjük a tárolókat a generáláshoz.
     * @param characters egy karakter lista
     * @param fields egy mező lista
     * @param polarBear a jegesmedve
     */
    public MapGenerator(ArrayList<Mezo> fields, ArrayList<Karakter> characters, Jegesmedve polarBear){

        this.fields = fields;
        this.characters = characters;
        this.bear = polarBear;
    }
    /**
     * Beállítja a mezők szomszédjait.
     * @param palya a megadott pálya.
     */
    public static void setNeighbours(Mezo[][] palya){

        for (int i = 0; i < Model.DEFAULT_MAP_HEIGHT; i++)
            for (int j = 0; j < Model.DEFAULT_MAP_WIDTH ; j++)
                for (int k = 0; k < Model.DEFAULT_MAP_HEIGHT; k++)
                    for (int l = 0; l < Model.DEFAULT_MAP_WIDTH; l++)
                        if(Math.abs(i-k) == 0 && Math.abs(j-l) == 1 || Math.abs(i-k) == 1 && Math.abs(j-l) == 0)
                            palya[i][j].setSzomszed(palya[k][l]);
    }
    /**
     * Beállítjuk hogy mennyi kutatók és az eszkimók számát a generéléshoz.
     * Megadhatjuk hogy lesz-e jegesmedve.
     * @param researcherCount A kutatók száma.
     * @param eskimoCount Az eszkimók száma.
     * @param polarBear A pálya tartalmaz-e jegesmedvét.
     */
    public static void setGenerator(int researcherCount, int eskimoCount, boolean polarBear ){

        MapGenerator.researcherCount = researcherCount;
        MapGenerator.eskimoCount = eskimoCount;
        MapGenerator.polarBear = polarBear;
    }
    /**
     * Létrehozunk egy teljesen véletlenszerű játékteret.
     */
    public void generateRandomMap(){

        fields.clear();
        characters.clear();
        bear = null;

        ArrayList<Mezo> generatedFields = generateFields();

        Mezo[][] board = new Mezo[Model.DEFAULT_MAP_HEIGHT][Model.DEFAULT_MAP_WIDTH];
        fillBoardRandomly(generatedFields, board);
        setNeighbours(board);

        for (int i = 0; i < Model.DEFAULT_MAP_HEIGHT; i++)
            fields.addAll(Arrays.asList(board[i]).subList(0, Model.DEFAULT_MAP_WIDTH));
    }
    /**
     * Az alap mező listát bővítjük ki további véletlenszerű mezőkkel ezzel létrehozva a teljes játékteret.
     */
    private ArrayList<Mezo> generateFields() {

        ArrayList<Mezo> generatedFields = new ArrayList<>(generateInitFields());

        boolean full = false;

        int maxCapacity = researcherCount + eskimoCount + 1;

        while (!full){

            int number = new Random().nextInt(100);

            if(number < HOLE)
                generatedFields.add(new Lyuk(number < HOLE_COVERAGE));

            else if(number < UNSTABLE)
                generatedFields.add(new InstabilJegtabla(true, maxCapacity, number < ITEM_CHANCE));

            else if(number < STABLE)
                generatedFields.add(new StabilJegtabla(true, number < ITEM_CHANCE));

            full = generatedFields.size() == Model.DEFAULT_MAP_HEIGHT * Model.DEFAULT_MAP_WIDTH;
        }

        return generatedFields;
    }
    /**
     * Létre hozzuk azt a mező listát amelyeken a játékhoz szükséges alapok kellenek(min. 1-1 kutató-eszkimó és a játék megnyeréséhez szükséges 3 tárgy)
     *
     */
    private ArrayList<Mezo> generateInitFields() {

        ArrayList<Mezo> fields = new ArrayList<>();

        for(int i = 0; i < MapGenerator.researcherCount; i++){
            StabilJegtabla ice = new StabilJegtabla();
            Kutato researcher = new Kutato(ice);
            characters.add(researcher);
            ice.befogad(researcher);
            fields.add(ice);
        }

        for(int i = 0; i < MapGenerator.eskimoCount; i++){
            StabilJegtabla ice = new StabilJegtabla();
            Eszkimo eskimo = new Eszkimo(ice);
            characters.add(eskimo);
            ice.befogad(eskimo);
            fields.add(ice);
        }

        if(polarBear) {
            StabilJegtabla ice = new StabilJegtabla();
            Jegesmedve polarBearAnimal = new Jegesmedve(ice);
            bear = polarBearAnimal;
            ice.befogad(polarBearAnimal);
            fields.add(ice);
        }

        StabilJegtabla flareGunIce = new StabilJegtabla();
        flareGunIce.setTargy(new Pisztoly());
        flareGunIce.setHoreteg(1);
        fields.add(flareGunIce);

        StabilJegtabla cartridgeIce = new StabilJegtabla();
        cartridgeIce.setTargy(new Patron());
        cartridgeIce.setHoreteg(1);
        fields.add(cartridgeIce);

        StabilJegtabla flareIce = new StabilJegtabla();
        flareIce.setTargy(new Jelzofeny());
        flareIce.setHoreteg(1);
        fields.add(flareIce);

        return fields;
    }
    /**
     * A paraméterben átadott mezőkkel véletlenszerűen feltölti a pályát.
     * @param mezok A mezőket tároló lista.
     * @param palya Maga a pálya.
     */
    private void fillBoardRandomly(ArrayList<Mezo> mezok, Mezo[][] palya){

        ArrayList<Point> freeCoords = new ArrayList<>();
        for (int i = 0; i < Model.DEFAULT_MAP_HEIGHT; i++)
            for (int j = 0; j < Model.DEFAULT_MAP_WIDTH; j++)
                freeCoords.add(new Point(i, j));

        for (Mezo m : mezok){

            Point coord = getRandomCoords(freeCoords);
            palya[coord.x][coord.y] = m;
        }
    }
    /**
     * Véletlenszerű koordinátával tér vissza.
     * @param coords
     */
    private Point getRandomCoords(ArrayList<Point> coords){

        Point coord = coords.get(new Random().nextInt(coords.size()));
        coords.remove(coord);

        return coord;
    }
}
