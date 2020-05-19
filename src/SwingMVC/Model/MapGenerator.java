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

    public static int HOLE = 20;
    public static int UNSTABLE = 30;
    public static int STABLE = 50;
    public static int HOLE_COVERAGE = 30;
    public static int ITEM_CHANCE = 60;

    private ArrayList<Mezo> fields;
    private ArrayList<Karakter> characters;
    private Jegesmedve bear;

    public MapGenerator(ArrayList<Mezo> fields, ArrayList<Karakter> characters, Jegesmedve polarBear){

        this.fields = fields;
        this.characters = characters;
        this.bear = polarBear;
    }

    public static void setNeighbours(Mezo[][] palya){

        for (int i = 0; i < Model.DEFAULT_MAP_HEIGHT; i++)
            for (int j = 0; j < Model.DEFAULT_MAP_WIDTH ; j++)
                for (int k = 0; k < Model.DEFAULT_MAP_HEIGHT; k++)
                    for (int l = 0; l < Model.DEFAULT_MAP_WIDTH; l++)
                        if(Math.abs(i-k) == 0 && Math.abs(j-l) == 1 || Math.abs(i-k) == 1 && Math.abs(j-l) == 0)
                            palya[i][j].setSzomszed(palya[k][l]);
    }

    public static void setGenerator(int researcherCount, int eskimoCount, boolean polarBear ){

        MapGenerator.researcherCount = researcherCount;
        MapGenerator.eskimoCount = eskimoCount;
        MapGenerator.polarBear = polarBear;
    }

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

    private Point getRandomCoords(ArrayList<Point> coords){

        Point coord = coords.get(new Random().nextInt(coords.size()));
        coords.remove(coord);

        return coord;
    }
}
