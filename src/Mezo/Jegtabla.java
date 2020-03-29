package Mezo;

import Karakter.Karakter;
import Szkeleton.MethodCallHandler;
import Targy.Targy;

public abstract class Jegtabla extends Mezo {

    private boolean igluzott;
    private Targy targy;

    public void getTargy(){}

    public abstract void befogad();

    @Override
    public void setIgluzott(){}
}
