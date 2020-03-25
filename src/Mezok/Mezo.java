package Mezok;

import Karakterek.Karakter;
import Szkeleton.Program;

import java.util.List;

public abstract class Mezo {

    private int horeteg;
    protected int kapacitas;
    private List<Karakter> karakterek;
    private List<Mezo> szomszedok;

    public abstract void vihar();

    public void setSzomszed(Mezo mezo){}

    public void havatCsokkent(int n){}

    public abstract void befogad(Karakter karakter);

    //TODO: Szkeleton után átírni Karakter-re a visszatérést
    public void kiad(Karakter karakter){

        Program.write("Mezo.kiad()");
    }

    //TODO: Szkeleton után átírni boolean-ra a visszatérést
    public void szomszedE(Mezo mezo){

        Program.write("Mezo.szomszedE()");
    }
}
