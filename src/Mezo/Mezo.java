package Mezo;

import Exceptions.ItemNotFoundException;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Mozgathato.*;
import Proto.ProtoProgram;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.AtfordulasEvent;
import SwingMVC.Eventhandling.Events.ViharEvent;
import Targy.Kotel;
import Targy.Targytipus;

import java.util.ArrayList;
import java.util.List;

/**
 * Absztrakt mezo osztaly. Ez jelkepezi a leptheto mezuket a jatekban.
 */
public abstract class Mezo implements VizbeesesListener {

    /**
     * A mezon talalhato homennyiseget jelkepezi.
     * Ha 0 erteku, akkor latszik, hogy a mezo lyuk-e.
     */
    protected int horeteg;

    /**
     * A mezo kapacitasat jelkepezi.
     * Ha a mezo stabil jegtabla, akkor vegtelen.
     * Ha a mezo instabil jegtabla, akkor veges es ha tullepik, akkor a rajta allo karakterek vizbe esnek.
     * Ha a mezo lyuk, akkor nulla, es a karakterek, amik ralepnek egybol vizbe esnek.
     */
    protected int kapacitas;

    /**
     * A mezon allo jegesmedvet jelkepezi.
     */
    protected Jegesmedve jegesmedve;

    /**
     * A mezo karakterlistaja. Itt tarolja a tartalmazott karaktereket
     */
    protected List<Karakter> karakterek = new ArrayList<Karakter>();

    /**
     * A mezo szomszedos mezoket tarolo listaja.
     */
    protected List<Mezo> szomszedok = new ArrayList<Mezo>();

    public void setJegesmedve(Jegesmedve jegesmedve){

        Logger.log();

        this.jegesmedve = jegesmedve;
    }

    public void addKarakter(Karakter karakter){

        Logger.log();

        karakterek.add(karakter);
    }

    public void setHoreteg(int horeteg) {

        Logger.log();

        if(horeteg > 4)
            this.horeteg = 4;

        else
            this.horeteg = horeteg;
    }

    public void setKapacitas(int kapacitas) {

        Logger.log();

        this.kapacitas = kapacitas;
    }

    public Jegesmedve getJegesmedve(){

        Logger.log();

        return jegesmedve;
    }

    public List<Karakter> getKarakterek() {

        Logger.log();

        return karakterek;
    }

    public int getHoreteg(){

        Logger.log();

        return horeteg;
    }

    /**
     * Visszater a mezo kapacitasaval.
     */
    public int getKapacitas(){

        Logger.log();

        return kapacitas;
    }

    public boolean tudnakEOsszeszerlni(){

        Logger.log();

        boolean jelzofeny = false, raketa = false, patron = false;

        for(Karakter k : karakterek){
            try { k.keres(Targytipus.JELZOFENY).hasznal(k); jelzofeny = true; }
            catch (ItemNotFoundException ignored) {}
        }

        for(Karakter k : karakterek){
            try { k.keres(Targytipus.PATRON).hasznal(k); patron = true; }
            catch (ItemNotFoundException ignored) {}
        }

        for(Karakter k : karakterek){
            try { k.keres(Targytipus.PISZTOLY).hasznal(k); raketa = true; }
            catch (ItemNotFoundException ignored) {}
        }

        return raketa && patron && jelzofeny;
    }

    public boolean probalMenteni(Karakter karakter){

        Logger.log();

        for(Karakter k : karakterek){

            try { ((Kotel)k.keres(Targytipus.KOTEL)).hasznal(karakter, k); return true; }
            catch (ItemNotFoundException ignored) {}
        }

        return false;
    }

    /**
     * A jatekban a vihart jelkepezi.
     * Novlei veletlenszeru mennyiseggel a havat,
     * es a mezon allo karakterek testhojet csokkenti egyel.
     */
    public void vihar(){

        Logger.log();

        setHoreteg(horeteg + ProtoProgram.getRandomNumber(2));

        Controller.getInstance().viharEvent(new ViharEvent(this));
    }

    /**
     * Beallitja a mezo szomszedjat.
     * Hozzaadja a szomszedlistajahoz, ha meg nem szomszedja,
     * valamint a celmezo szomszedjanak beallitja sajat magat.
     */
    public void setSzomszed(Mezo mezo){

        Logger.log();

        if(!szomszedE(mezo)) {

            szomszedok.add(mezo);

            if (!mezo.szomszedE(this))
                mezo.setSzomszed(this);
        }
    }

    public Mezo getRandomSzomszed(){

        Logger.log();

        return szomszedok.get(ProtoProgram.getRandomNumber(szomszedok.size()));
    }

    /**
     * Csokkenti a horeteget a megadott mennyiseggel.
     */
    public void havatCsokkent(int retegSzam){

        Logger.log();

        horeteg -= retegSzam;
    }

    /**
     * Ha karaktert kap azt a karakterlistaba rakja, ha medvet, akkor a medvebe.
     */
    public void befogad(Mozgathato mozgathato) {

        Logger.log();

        if(mozgathato.tipus().equals(MozgathatoTipus.JEGESMEDVE))
            jegesmedve = (Jegesmedve) mozgathato;

        else
            karakterek.add((Karakter) mozgathato);
    }

    /**
     * Kiveszi a megadott karakter/medvet a mezobol.
     */
    public void kiad(Mozgathato mozgathato){

        Logger.log();

        if(mozgathato.tipus().equals(MozgathatoTipus.JEGESMEDVE))
            jegesmedve = null;

        else
            karakterek.remove(mozgathato);
    }

    public boolean halalE(){

        Logger.log();

        return jegesmedve != null && !karakterek.isEmpty();
    }

    /**
     * Ellenorzi, hogy a megadott mezo szomszedos-e.
     */
    public boolean szomszedE(Mezo mezo){

        Logger.log();

        return szomszedok.contains(mezo);
    }

    /**
     * Ha a szomszedos mezok egyiken van karakter kotellel, akkor az kimenti a vizbe esett karaktereket.
     */
    @Override
    public void segitseg(Karakter karakter){

        Controller.getInstance().atfordultEvent(new AtfordulasEvent(this));

        horeteg = 0;

        Logger.log();

        for(Mezo m : szomszedok)
            if(m.probalMenteni(karakter)) {
                return;
            }

        if(kapacitas == 0)
            karakter.meghal("Sajnos lyukra léptél és nem mentett ki senki...");

        else
            karakter.meghal("Felfordult a jégtábla és nem volt segítség...");
    }
}
