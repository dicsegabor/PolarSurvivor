package Mezo;

import Karakter.Karakter;
import Szkeleton.MethodCallHandler;

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
    public void vihar(){}

    public void setSzomszed(){}

    public void getKapacitas(){}

    public void havatCsokkent(){}

    public abstract void befogad();

    //TODO: Szkeleton után átírni Karakter-re a visszatérést
    public void kiad(){}

    //TODO: Szkeleton után átírni boolean-ra a visszatérést
    public void szomszedE(){}

    @Override
    public void segitseg(){}

    public abstract void setIgluzott();
}
