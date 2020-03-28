package Karakterek;

import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Program;
import Targyak.*;

import java.util.List;

public class Karakter {

    private int testho;
    private int munka;
    protected Mezo mezo = new StabilJegtabla();
    private List<Targy> targyak;

    public void felvesz(){

        Program.writeToBuffer("Karakter.felvesz()");
        Program.indent++;
        munkaCsokkent();
    }

    public void meghal(){

        Program.writeToBuffer("Karakter.meghal()");
    }

    public void lep(Mezo mezo){

        Program.writeToBuffer("Karakter.lep(){");
        Program.indent++;
        this.mezo.szomszedE(mezo);
        this.mezo.kiad(this);
        mezo.befogad(this);
        munkaCsokkent();
    }

    public void as(){

        Program.writeToBuffer("Karakter.as(){");
        Program.indent++;
        munkaCsokkent();
    }

    public void kombinal(){

        Pisztoly gun = new Pisztoly();
        Patron cartridge = new Patron();
        Jelzofeny flare = new Jelzofeny();
        Mezo field = new StabilJegtabla();

        Program.writeToBuffer("Karakter.kombinal(){");
        Program.indent++;
        gun.hasznal(field);
        cartridge.hasznal(field);
        flare.hasznal(field);
        munkaCsokkent();
    }

    //TODO: Szkeleton után átírni Targy-ra a visszatérést
    public void keres(Targytipus keresettTargy){

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
