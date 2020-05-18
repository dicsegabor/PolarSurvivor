package Mezo;

import Epulet.*;
import Exceptions.ItemNotFoundException;
import Mozgathato.*;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.EpitesEvent;
import SwingMVC.Eventhandling.Events.ViharEvent;
import Targy.*;

/**
 * A jegtablat jelkepezi. Tarolhat targyat.
 * Absztrakt osztaly, belole szarmazik le a stbil es instabil jegtabla.
 */
public abstract class Jegtabla extends Mezo {

    /**
     * A mezo altal tarolt targy, amit a karakter felvehet.
     */
    protected Targy targy;

    /**
     * A mezon talalhato epulet, ami befolyasolja a karakterek viszonyulasat a kornyezethez.
     */
    protected Epulet epulet;

    /**
     * Meghivja a mezo viharat, valamint teszteli, hogy van-e epulet.
     * Ha van, akkor nem csokken a karakterek testhoje, viszint elpusztul az epulet.
     * Ha nincs, akkor csokken a testhojuk egyel.
     */
    @Override
    public void vihar(){

        Logger.log();

        super.vihar();

        if(epulet == null)
            karakterek.forEach(k -> k.testhotCsokkent(1));

        else
            epulet = null;

        Controller.getInstance().viharEvent(new ViharEvent(this));
    }

    /**
     * A jegtablara rak egy epuletet, ha nincs meg rajta.
     * @param epulet
     */
    public void epit(Epulet epulet){

        Logger.log();

        if(epulet != null) {

            this.epulet = epulet;

            Controller.getInstance().epitesEvent(new EpitesEvent(this, this.epulet));

            if(osszsuly() > kapacitas)
                for(Karakter k : karakterek) {

                    try { k.keres(Targytipus.BUVARRUHA).hasznal(k); }
                    catch (ItemNotFoundException e) { segitseg(k); }
                }
        }

        else
            System.out.println("Mar van epulet a mezon!");
    }

    public void setTargy(Targy targy) {

        Logger.log();

        this.targy = targy;
    }

    /**
     * Kiadja a tarolt targyat es eltavolitja a mezorol.
     */
    public Targy felvesz(){

        Logger.log();

        if(horeteg == 0) {
            Targy targy = this.targy;

            this.targy = null;

            return targy;
        }

        return null;
    }

    public Epulet getEpulet() {

        return epulet;
    }

    public Targy getTargy() {

        Logger.log();

        return targy;
    }

    @Override
    public boolean halalE(){

        Logger.log();

        if(jegesmedve != null) {

            if (epulet != null) {

                if (!epulet.epulettipus().equals(Epulettipus.IGLU))
                    return super.halalE();
            }

            else
                return super.halalE();
        }

        return false;
    }

    public int osszsuly(){

        Logger.log();

        int suly = karakterek.size();
        if(jegesmedve != null)
            suly++;

        if (epulet != null)
            suly++;

        return suly;
    }

    /**
     * Berak egy karaktert a karakterlistajaba.
     */
    public abstract void befogad(Mozgathato mozgathato);
}
