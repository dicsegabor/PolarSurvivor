package Karakter;

import Mezo.Mezo;
import Targy.*;

import java.util.List;

/**
 * A játékban megvalósított karakterek (Kutató, Eszkimó) alapja.
 */
public class Karakter {

    /**
     * A karakter életereje gyakorlatilag. Ha elfogy és a karakter meghal, akkor vége a játéknak.
     */
    private int testho;

    /**
     * Bármilyen cselekvés munkát emészt fel. Ha elfogy, akkor a karakter nem tud semmit csinálni, és véget ér a köre.
     * A munnka a körök végén újratöltődik.
     */
    private int munka;

    /**
     * Tárolja, hogy a karakter éppen melyik mezőn áll.
     */
    protected Mezo mezo;

    /**
     * A karakter tárgylistája, ebben tárolja a tárgyakat, amiket a karakter használni tud.
     */
    private List<Targy> targyak;

    /**
     * A karakter felveszi az őt tartalmazó mezőben található tárgyat
     * és hozzáadja a tárgylistájához.
     * Amennyiben a tárgy élelem, akkor el is fogyasztja azt.
     */
    public void felvesz(){}

    /**
     * A karakternek a teshője nullára csökken, és véget ér a játék.
     */
    public void meghal(){}

    /**
     * A karakter átlép egyik mezőből a másikba.
     * Csökken egyel a munka.
     */
    public void lep(){}

    /**
     * A karakter eltávolít valamennyi havat a mezőről.
     * Csökken egyel a munka.
     */
    public void as(){}

    /**
     * A karakter osszerakja a jelzőrakétát és véget ér a játék.
     */
    public void kombinal(){}

    /**
     * A karakter kikeres egy tárgyat a tárgylistájából.
     */
    public void keres(){}

    /**
     * A karakter testhője lecsökken egyel.
     */
    public void testhotCsokkent(){}

    /**
     * A karakter munkája lecsökken egyel.
     */
    public void munkaCsokkent(){}
}
