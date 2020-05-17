package SwingMVC.Model;

import Mezo.*;
import Mozgathato.Eszkimo;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;

import java.util.ArrayList;

public class Model {

    private ArrayList<Karakter> karakterek;
    private ArrayList<Mezo> mezok;
    private Jegesmedve jegesmedve;

    public Model(){

        karakterek = new ArrayList<>();
        mezok = new ArrayList<>();
        init();
    }

    public Mezo getMezo(int ID){

        return mezok.get(ID);
    }

    public Karakter getKarakter(int ID){

        return karakterek.get(ID);
    }

    private void init(){

        Mezo mezo = new StabilJegtabla();
        Karakter karakter = new Eszkimo(mezo);

        mezo.addKarakter(new Eszkimo(mezo));
        mezo.setHoreteg(1);

        mezok.add(mezo);
        karakterek.add(karakter);
    }
}
