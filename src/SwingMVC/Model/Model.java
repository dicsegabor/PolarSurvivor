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
import Targy.Targytipus;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
        init();

        addGameEventListener();
    }

    public void reset(){

        karakterek.clear();
        mezok.clear();
        jegesmedve = null;
        init();
    }

    public ArrayList<Karakter> getKarakterek() {

        return karakterek;
    }

    public Karakter getNextKarakter(Karakter karakter){

        if(karakterek.indexOf(karakter) < karakterek.size() - 1)
            return karakterek.get(karakterek.indexOf(karakter) + 1);

        else{

            Controller.getInstance().korvege(new KorvegeEvent(this));
            return karakterek.get(0);
        }
    }

    private void init() {

        File text = new File("src\\SwingMVC\\Model\\Map.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(text);
        } catch (FileNotFoundException e) {
            System.out.println("lol");
        }

        Mezo[][] palya = new Mezo[DEFAULT_MAP_HEIGHT][DEFAULT_MAP_WIDTH];

        while(scanner.hasNextLine()){

        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++) {
            for (int j = 0; j < DEFAULT_MAP_WIDTH ; j++) {

                    String tmp = scanner.nextLine();
                    String[] sor = tmp.split("\\t");

                    if(sor[0].equals("LYUK")){
                        if(0 == Integer.parseInt(sor[2])){
                            palya[i][j] = new Lyuk(false);
                        }

                        else{
                            palya[i][j] = new Lyuk(true);
                        }

                    }

                    else if(sor[0].equals("STABIL")){
                        StabilJegtabla stabil = new StabilJegtabla();
                        stabil.setHoreteg(Integer.parseInt(sor[2]));
                        stabil.setTargy(Targytipus.letrehoz(Targytipus.valueOf(sor[3])));
                        palya[i][j] = stabil;
                    }

                    else if(sor[0].equals("INSTABIL")){
                        InstabilJegtabla instabil = new InstabilJegtabla(Integer.parseInt(sor[1]));
                        instabil.setHoreteg(Integer.parseInt(sor[2]));
                        if(!sor[3].equals("null"))
                            instabil.setTargy(Targytipus.letrehoz(Targytipus.valueOf(sor[3])));
                        palya[i][j] = instabil;
                    }
                }
            }
        }

        setSzomszedok(palya);

        Karakter karakter1 = new Eszkimo(palya[1][2]);
        palya[1][2].addKarakter(karakter1);
        karakterek.add(karakter1);

        Karakter karakter2 = new Kutato(palya[3][2]);
        palya[3][2].addKarakter(karakter2);
        karakterek.add(karakter2);

        jegesmedve = new Jegesmedve(palya[2][4]);
        palya[2][4].befogad(jegesmedve);

        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++)
            for (int j = 0; j < DEFAULT_MAP_WIDTH; j++)
                mezok.add(palya[i][j]);
    }

    private void setSzomszedok(Mezo[][] palya){

        for (int i = 0; i < DEFAULT_MAP_HEIGHT; i++)
            for (int j = 0; j < DEFAULT_MAP_WIDTH ; j++)
                for (int k = 0; k < DEFAULT_MAP_HEIGHT; k++)
                    for (int l = 0; l < DEFAULT_MAP_WIDTH; l++)
                        if(Math.abs(i-k) == 0 && Math.abs(j-l) == 1 || Math.abs(i-k) == 1 && Math.abs(j-l) == 0)
                            palya[i][j].setSzomszed(palya[k][l]);
    }

    public ArrayList<Mezo> generateRandomMap(){

        ArrayList<Mezo> mezok = new ArrayList<>();

        int researcherNumber = 1;
        int eskimoNumber = 1;
        boolean polarBear = true;



        Mezo[][] palya = new Mezo[DEFAULT_MAP_HEIGHT][DEFAULT_MAP_WIDTH];



        return mezok;
    }

    private Point getRandomCoords(){

        return new Point(new Random().nextInt(DEFAULT_MAP_HEIGHT), new Random().nextInt(DEFAULT_MAP_WIDTH));
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

    public void leptet(Karakter karakter, Mezo mezo){

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

    public void karakterKorVege(Karakter activeKarakter){


    }
}
