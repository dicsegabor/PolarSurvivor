package Mezok;

import Karakterek.Karakter;
import Szkeleton.Program;
import Targyak.Kotel;

import java.util.ArrayList;
import java.util.List;

public abstract class Mezo implements VizbeesesListener {

    private int horeteg;
    protected int kapacitas;
    private List<Karakter> karakterek = new ArrayList<>();
    private List<Mezo> szomszedok;

    public abstract void vihar();

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
        karakter.keres(new Kotel());
    }

    public abstract void setIgluzott(boolean igluzott);
}
