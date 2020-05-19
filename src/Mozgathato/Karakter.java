package Mozgathato;

import Exceptions.ItemNotFoundException;
import Mezo.Mezo;
import Mezo.Jegtabla;
import Proto.ProtoProgram;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.*;
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
    protected List<Targy> targyak = new ArrayList<Targy>();

    public int getMunka() {

        return munka;
    }

    public int getTestho() {

        return testho;
    }

    public Mezo getMezo() {

        Logger.log();

        return mezo;
    }

    public List<Targy> getTargyak() {

        return targyak;
    }

    /**
     * A karakter felveszi az ot tartalmazo mezoben talalhato targyat
     * es hozzaadja a targylistajahoz.
     * Amennyiben a targy elelem, akkor el is fogyasztja azt.
     */
    public void felvesz() {

        if(mezo.getHoreteg() == 0) {


            Logger.log();

            Targy targy = ((Jegtabla) mezo).felvesz();

            if (targy == null) return;

            Controller.getInstance().targyfelvetelEvent(new TargyfelvetelEvent(this, targy));

            if (targy.tipus().equals(Targytipus.ELELEM))
                targy.hasznal(this);

            else
                targyak.add(targy);

            Controller.getInstance().statusUpdate(new KarakterStatusUpdateEvent(this));
        }
    }

    /**
     * A karakternek a teshoje nullara csokken vagy megeszi a medve,
     * akkor meghivodik, kiirja a halaluzenetet es veget er a jatek.
     * @param halalUzenet Ezt irja ki.
     */
    public void meghal(String halalUzenet){

        Logger.log();

        ProtoProgram.jatekVege("Meghalt a karakter!");

        Controller.getInstance().jatekVege(new JatekvegeEvent(this, halalUzenet));
    }

    /**
     * A karakter atlep egyik mezobol a masikba.
     * Csokken egyel a munka.
     */
    @Override
    public void lep(Mezo hova){

        if(this.mezo.szomszedE(hova)){

            Controller.getInstance().lepesEvent(new LepesEvent(this, hova, this.mezo));
            Logger.log();

            this.mezo.kiad(this);
            this.mezo = hova;
            hova.befogad(this);

            ProtoProgram.halalEllorzes(hova);
            munkaCsokkent(1);
        }
    }

    /**
     * A karakter keres lapatot, vag torekeny lapatot, és ha van, akkor hasznalja.
     * Amennyiben nincs csak egyel csokkenti a havat.
     * Csokken egyel a munka.
     */
    public void as(){

        Logger.log();

        try { keres(Targytipus.LAPAT).hasznal(this); }

        catch (ItemNotFoundException e) {

            try { keres(Targytipus.TOREKENYLAPAT).hasznal(this); }

            catch (ItemNotFoundException ex) {

                mezo.havatCsokkent(1);
            }
        }

        munkaCsokkent(1);

        Controller.getInstance().asasEvent(new AsasEvent(this));
    }

    /**
     * A karakter megkerdezi a mezot, hogy a rajta allo
     * karaktereknel ott van-e a tobbi elem es van-e eleg munkajuk.
     * Ha igen, akkor veget er a jatek.
     */
    public void kombinal(){

        if(mezo.tudnakEOsszeszerlni()){

            ProtoProgram.jatekVege("Sikerult! Megmenekult mindenki!");
            Controller.getInstance().jatekVege(new JatekvegeEvent(this, "Sikerült! Megmenekültünk!"));
        }

        else
            System.out.println("Nincsenek meg a szukseges targyak!");
    }

    /**
     * A karakter kikeres egy targyat a targylistajabol.
     * @throws ItemNotFoundException Ha nincs az adoot targy a listaban ilyen kivetelt dob.
     */
    public Targy keres(Targytipus targytipus) throws ItemNotFoundException {

        Logger.log();

        int index = 0;

        for(Targy t : targyak){

            if(t.tipus().equals(targytipus))
                return targyak.get(index);

            index++;
        }

        throw new ItemNotFoundException("Nincs ilyen targy a karakternel: " + targytipus);
    }

    public void eldob(Targy targy){

        Logger.log();

        targyak.remove(targy);
    }

    /**
     * A karakter testhoje lecsokken egyel. Ha nullara csokken, akkor meghal.
     */
    public void testhotCsokkent(int mennyiseg){

        Logger.log();

        testho -= mennyiseg;

        Controller.getInstance().statusUpdate(new KarakterStatusUpdateEvent(this));

        if(testho <= 0)
            meghal("Megfagytam.");
    }

    /**
     * A karakter munkaja lecsokken egyel. Ha nullara csokken, akkor veget er a kore.
     */
    public void munkaCsokkent(int mennyiseg){

        Logger.log();

        munka -= mennyiseg;

        Controller.getInstance().statusUpdate(new KarakterStatusUpdateEvent(this));

        if(munka <= 0) {

            ProtoProgram.kovetkezoKarakter(this);
            Controller.getInstance().karakterKorvege(new KarakterKorvegeEvent(this));
        }
    }

    public void munkatVisszaallit(){

        munka = 4;
    }

    public MozgathatoTipus tipus(){

        return null;
    }
}
