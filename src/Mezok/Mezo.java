package Mezok;

import Karakterek.Karakter;
import Szkeleton.Program;
import Targyak.Targytipus;

import java.util.ArrayList;
import java.util.List;

public abstract class Mezo implements VizbeesesListener {

    private int horeteg;
    protected int kapacitas;
    //TODO: Beleírni a modellváltozást (igluzott a mező attribútuma lett)
    protected boolean igluzott;
    private List<Karakter> karakterek = new ArrayList<>();
    private List<Mezo> szomszedok;

    //TODO: Beleírni a modellváltozást (vihar nem absztrakt már)
    public void vihar(){

        Program.writeToBuffer("Mezo.vihar()");
    }

    public void setSzomszed(Mezo mezo){}

    public void havatCsokkent(int n){

        Program.writeToBuffer("Mezo.havatCsokkent(" + n + ")");
    }

    public abstract void befogad(Karakter karakter);

    //TODO: Szkeleton után átírni Karakter-re a visszatérést
    public void kiad(Karakter karakter){

        Program.writeToBuffer("Mezo.kiad()");
    }

    //TODO: Szkeleton után átírni boolean-ra a visszatérést
    public void szomszedE(Mezo mezo){

        Program.writeToBuffer("Mezo.szomszedE()");
    }

    @Override
    public void segitseg(Karakter karakter){

        Program.writeToBuffer("Mezo.segitseg(){");
        Program.indent++;
        karakter.keres(Targytipus.KOTEL);
    }

    public abstract void setIgluzott(boolean igluzott);
}
