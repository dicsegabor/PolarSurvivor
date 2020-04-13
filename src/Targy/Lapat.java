package Targy;

import Mozgathato.Karakter;

/**
 * Segitsegevel ket reteg havat ehet eltavolitani a mezorol.
 */
public class Lapat implements Targy {

    /**
     * Ket reteg havat takarit el a mezorol.
     */
    @Override
    public void hasznal(Karakter karakter) {}

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        return Targytipus.LAPAT;
    }
}
