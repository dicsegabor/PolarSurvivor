package Karakter;

import Mezo.Mezo;
import Targy.*;

import java.util.List;

/**
 * A jatekban megvalositott karakterek (Kutato, Eszkimo) alapja.
 */
public class Karakter {

    /**
     * A karakter eletereje gyakorlatilag. Ha elfogy es a karakter meghal, akkor vege a jateknak.
     */
    private int testho;

    /**
     * Barmilyen cselekves munkat emeszt fel. Ha elfogy, akkor a karakter nem tud semmit csinalni, es veget er a kore.
     * A munnka a korok vegen ujratoltodik.
     */
    private int munka;

    /**
     * Tarolja, hogy a karakter eppen melyik mezon all.
     */
    protected Mezo mezo;

    /**
     * A karakter targylistaja, ebben tarolja a targyakat, amiket a karakter hasznalni tud.
     */
    private List<Targy> targyak;

    /**
     * A karakter felveszi az ot tartalmazo mezoben talalhato targyat
     * es hozzaadja a targylistajahoz.
     * Amennyiben a targy elelem, akkor el is fogyasztja azt.
     */
    public void felvesz(){}

    /**
     * A karakternek a teshoje nullara csokken, es veget er a jatek.
     */
    public void meghal(){}

    /**
     * A karakter atlep egyik mezobol a masikba.
     * Csokken egyel a munka.
     */
    public void lep(){}

    /**
     * A karakter eltavolit valamennyi havat a mezorol.
     * Csokken egyel a munka.
     */
    public void as(){}

    /**
     * A karakter osszerakja a jelzoraketat es veget er a jatek.
     */
    public void kombinal(){}

    /**
     * A karakter kikeres egy targyat a targylistajabol.
     */
    public void keres(){}

    /**
     * A karakter testhoje lecsokken egyel.
     */
    public void testhotCsokkent(){}

    /**
     * A karakter munkaja lecsokken egyel.
     */
    public void munkaCsokkent(){}
}
