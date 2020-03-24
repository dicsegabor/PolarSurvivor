package Karakterek;

import Mezok.Mezo;
import Targyak.Targy;

import java.util.List;

public class Karakter {

    private int testho;
    private int munka;
    private Mezo mezo;
    private List<Targy> targyak;

    public void felvesz(){}

    public void meghal(){}

    public void lep(Mezo mezo){}

    public void as(){}

    public void kombinal(){}

    //TODO: Szkeleton után átírni Targy-ra a visszatérést
    public void keres(Targy keresettTargy){}

    public void testhotCsokkent(int n){}

    //TODO: Szkeleton után átírni boolean-ra a visszatérést
    public void munkaCsokkent(){}
}
