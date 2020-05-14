package MVC.Model;

import Mezo.Mezo;
import Mezo.StabilJegtabla;
import Mozgathato.Mozgathato;
import Mozgathato.Karakter;
import Mozgathato.Eszkimo;

import java.util.ArrayList;

public class GameModel {
    private ArrayList<Mozgathato> mozgathatok;
    private ArrayList<Karakter> karakterek;
    private ArrayList<Mezo> mezok;

    public GameModel() {
        mozgathatok = new ArrayList<Mozgathato>();
        karakterek = new ArrayList<Karakter>();
        mezok = new ArrayList<Mezo>();

        mezok.add(new StabilJegtabla());
        mezok.add(new StabilJegtabla());
        mezok.add(new StabilJegtabla());

        mezok.get(0).setSzomszed(mezok.get(1));
        mezok.get(1).setSzomszed(mezok.get(0));
        mezok.get(1).setSzomszed(mezok.get(2));
        mezok.get(2).setSzomszed(mezok.get(1));

        Eszkimo e1 = new Eszkimo(mezok.get(1));
        mezok.get(1).addKarakter(e1);
        karakterek.add(e1);
    }

    public ArrayList<Mezo> getMezok() { return mezok; }
    public ArrayList<Mozgathato> getMozgathatok() { return mozgathatok; }
    public Karakter getCurrentKarakter() { return karakterek.get(0); }
}
