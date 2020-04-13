package Mozgathato;

import Exceptions.ItemNotFoundException;
import Mezo.Mezo;
import Mezo.Jegtabla;
import Proto.Jatek;
import Targy.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A jatekban megvalositott karakterek (Kutato, Eszkimo) alapja.
 */
public class Karakter implements Mozgathato {

    /**
     * A karakter eletereje gyakorlatilag. Ha elfogy es a karakter meghal, akkor vege a jateknak.
     */
    protected int testho;

    /**
     * Barmilyen cselekves munkat emeszt fel. Ha elfogy, akkor a karakter nem tud semmit csinalni, es veget er a kore.
     * A munnka a korok vegen ujratoltodik.
     */
    protected int munka;

    /**
     * Tarolja, hogy a karakter eppen melyik mezon all.
     */
    protected Mezo mezo;

    /**
     * A karakter targylistaja, ebben tarolja a targyakat, amiket a karakter hasznalni tud.
     */
    private List<Targy> targyak = new ArrayList<Targy>();

    public Mezo getMezo() {

        return mezo;
    }

    /**
     * A karakter felveszi az ot tartalmazo mezoben talalhato targyat
     * es hozzaadja a targylistajahoz.
     * Amennyiben a targy elelem, akkor el is fogyasztja azt.
     */
    public void felvesz() {

        Targy targy = ((Jegtabla)mezo).getTargy();

        if(targy.tipus().equals(Targytipus.ELELEM))
            targy.hasznal(this);

        else
            targyak.add(targy);
    }

    /**
     * A karakternek a teshoje nullara csokken vagy megeszi a medve,
     * akkor meghivodik, kiirja a halaluzenetet es veget er a jatek.
     * @param halalUzenet Ezt irja ki.
     */
    public void meghal(String halalUzenet){

        //TODO: halalkiiras megvalositasa

        Jatek.jatekVege();
    }

    /**
     * A karakter atlep egyik mezobol a masikba.
     * Csokken egyel a munka.
     */
    @Override
    public void lep(Mezo mezo){

        this.mezo.kiad(this);

        mezo.befogad(this);

        munkaCsokkent(1);
    }

    /**
     * A karakter keres lapatot, vag torekeny lapatot, és ha van, akkor hasznalja.
     * Amennyiben nincs csak egyel csokkenti a havat.
     * Csokken egyel a munka.
     */
    public void as(){

        try { keres(Targytipus.LAPAT).hasznal(this); }

        catch (ItemNotFoundException e) {

            try { keres(Targytipus.TOREKENYLAPAT).hasznal(this); }

            catch (ItemNotFoundException ex) {

                mezo.havatCsokkent(1);
            }
        }

        munkaCsokkent(1);
    }

    /**
     * A karakter megkerdezi a mezot, hogy a rajta allo
     * karaktereknel ott van-e a tobbi elem es van-e eleg mukajuk.
     * Ha igen, akkor veget er a jatek.
     */
    public void kombinal(){}

    /**
     * A karakter kikeres egy targyat a targylistajabol.
     * @throws ItemNotFoundException Ha nincs az adoot targy a listaban ilyen kivetelt dob.
     */
    public Targy keres(Targytipus targytipus) throws ItemNotFoundException {

        int index = 0;

        for(Targy t : targyak){

            if(t.tipus().equals(targytipus))
                return targyak.get(index);;

            index++;
        }

        throw new ItemNotFoundException("Nincs ilyen targy a karakternel: " + targytipus);
    }

    /**
     * A karakter testhoje lecsokken egyel. Ha nullara csokken, akkor meghal.
     */
    public void testhotCsokkent(int mennyiseg){

        if(testho - mennyiseg <= 0)
            meghal("Megfagytam");

        else
            testho -= mennyiseg;
    }

    /**
     * A karakter munkaja lecsokken egyel. Ha nullara csokken, akkor veget er a kore.
     */
    public void munkaCsokkent(int mennyiseg){

        if(munka - mennyiseg <= 0)
            Jatek.kovetkezoKarakter();

        munka -= mennyiseg;
    }
}
