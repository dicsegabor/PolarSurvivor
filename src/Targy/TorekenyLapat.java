package Targy;

public class TorekenyLapat extends Lapat implements Targy {

    private int hasznalhato;

    public TorekenyLapat(){

        hasznalhato = 3;
    }

    @Override
    public void hasznal() {

        super.hasznal();

        hasznalhato--;

        if(hasznalhato == 0);
            //TODO: Kitalalni, hogy hogyan tunik el a lapat.
    }

    @Override
    public Targytipus tipus() {

        return Targytipus.TOREKENYASO;
    }
}
