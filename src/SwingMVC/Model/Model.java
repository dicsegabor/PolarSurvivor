package SwingMVC.Model;

import Exceptions.ItemNotFoundException;
import Mezo.*;
import Mozgathato.Eszkimo;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Targy.Targytipus;

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

    //TODO: inicializálás
    private void init(){

        Mezo mezo = new StabilJegtabla();
        Karakter karakter = new Eszkimo(mezo);

        mezo.addKarakter(new Eszkimo(mezo));
        mezo.setHoreteg(1);

        mezok.add(mezo);
        karakterek.add(karakter);
    }

    public Mezo getMezo(int ID){

        return mezok.get(ID);
    }

    public Karakter getKarakter(int ID){

        return karakterek.get(ID);
    }

    // Menüpontok
    public void leptet(Karakter karakter, Mezo mezo){

        karakter.lep(mezo);
    }

    public void as(Karakter karakter) {

        karakter.as();
    }

    public void targyatFelvesz(Karakter karakter) {
        karakter.felvesz();
    }

    public void iglutEpit(Eszkimo eszkimo) {
        eszkimo.iglutEpit();
    }

    public void satratEpit(Karakter karakter) {
        try {
            karakter.keres(Targytipus.SATOR).hasznal(karakter);
        } catch (ItemNotFoundException e) {
           //TODO: kell-e? mivel csak akkor jelenik meg a menüpont, ha van nála
            e.printStackTrace();
        }
    }

    public void osszeszerel(Karakter karakter) {

        karakter.kombinal();
    }
}
