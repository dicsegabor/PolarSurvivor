package Targy;

import Mozgathato.Karakter;

public class TorekenyLapat extends Lapat implements Targy {

    private int hasznalhato;

    public TorekenyLapat(){

        hasznalhato = 3;
    }

    /**
     * Ket reteg havat takarit el a mezorol. Csokken egyel a tartossaga, es ha nulla eltunik.
     * @param karakter A karakter, aki hasznalja
     */
    @Override
    public void hasznal(Karakter karakter) {

        super.hasznal(karakter);

        hasznalhato--;

        if(hasznalhato == 0);
            //TODO: Kitalalni, hogy hogyan tunik el a lapat.
    }

    @Override
    public Targytipus tipus() {

        return Targytipus.TOREKENYLAPAT;
    }
}
