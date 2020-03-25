package Karakterek;

import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Program;
import Targyak.Kotel;
import Targyak.Targy;

import java.util.List;

public class Karakter {

    private int testho;
    private int munka;
    private Mezo mezo = new StabilJegtabla();
    private List<Targy> targyak;

    public void felvesz(){}

    public void meghal(){

        Program.writeToBuffer("Karakter.meghal()");
    }

    public void lep(Mezo mezo){

        Program.writeToBuffer("Karakter.lep(){");
        Program.indent++;
        this.mezo.szomszedE(mezo);
        this.mezo.kiad(this);
        mezo.befogad(this);
    }

    public void as(){

        Program.writeToBuffer("Karakter.as()");
    }

    public void kombinal(){

        Program.writeToBuffer("Karakter.kombinal()");
    }

    //TODO: Szkeleton után átírni Targy-ra a visszatérést
    public void keres(Kotel keresettTargy){

        Program.writeToBuffer("Karakter.keres()");
    }

    public void testhotCsokkent(int n){

        Program.writeToBuffer("Karakter.testhotCsokkent()");
    }

    //TODO: Szkeleton után átírni boolean-ra a visszatérést
    public void munkaCsokkent(){

        Program.writeToBuffer("Karakter.munkatCsokkent()");
    }
}
