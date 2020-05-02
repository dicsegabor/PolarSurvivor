package MVC.Model;

import Mezo.Mezo;
import Mozgathato.Mozgathato;
import Mozgathato.Karakter;

import java.util.ArrayList;

public class GameModel {
    private ArrayList<Mozgathato> mozgathatok;
    private ArrayList<Karakter> karakterek;
    private ArrayList<Mezo> mezok;

    public GameModel() {
        mozgathatok = new ArrayList<Mozgathato>();
        karakterek = new ArrayList<Karakter>();
        mezok = new ArrayList<Mezo>();
    }
}
