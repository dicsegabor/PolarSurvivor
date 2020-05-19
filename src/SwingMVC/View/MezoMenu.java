package SwingMVC.View;

import Exceptions.ItemNotFoundException;
import Mezo.*;
import Mozgathato.Karakter;
import Mozgathato.MozgathatoTipus;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.KarakterKorvegeEvent;
import Targy.Targytipus;

import javax.swing.*;

/**
 * A jobb klikk hatására elõugró menü, amivel a karaktereket irányíthatjuk
 */
public class MezoMenu extends JPopupMenu {

    /**
     * Tárolja a hozzá tartozó mezoViewt
     */
    private MezoView mezoView;

    /**
     * Jobb-klikk menü
     * @param mezoView A mezõ, amire a játékos a képernyõn kattintott
     */
    public MezoMenu(MezoView mezoView){

        super();
        this.mezoView = mezoView;

        // A megjelenítendõ opciók betöltése
        listSelectableMenuPoints();
    }

    /**
     * A tárolt mezoView alapján, csak a releváns menüpontokat jeleníti meg
     */
    private void listSelectableMenuPoints(){

        // A jelenleg soron lévõ karakter
        Karakter aktivKarakter = Controller.getInstance().getActiveKarakter();
        // A mezõ, amin a jelenleg soron lévõ karakter áll
        Mezo aktivKarakterMezo = aktivKarakter.getMezo();

        /* Kör vége menüpont
         * Bármelyik mezõn választható
         */
        addEndTurnMenuPoint();

        // A többi menüpont csak szomszédos vagy saját mezõn érhetõ el
        if(!mezoView.getMezo().szomszedE(aktivKarakterMezo) &&
           !mezoView.getMezo().equals(aktivKarakterMezo))
            return;

        /*
         * Jelzõpisztoly összeszerelése
         * Csak saját mezõn
         * Akkor, ha már megvan minden alkatrész a mezõn álló karaktereknél
         */
        if(mezoView.getMezo().equals(aktivKarakterMezo) && aktivKarakterMezo.tudnakEOsszeszerlni())
            addCombineMenuPoint();

        /*
         * Csak szomszédos mezõn elérhetõ opciók ezután
         */
        if(mezoView.getMezo().szomszedE(aktivKarakterMezo)) {

            // Kutató: jég kapacitását nézheti
            if(aktivKarakter.tipus().equals(MozgathatoTipus.KUTATO))
                addCheckIceMenuPoint();

            /*
             * Lépés
             * Csak az aktív karakter mezõjével szomszédos mezõre
             *
             * Lyuk esetén
             */
            if(mezoView.getMezo().getClass().equals(Lyuk.class)){

                // Van hó a mezõn -> léphet
                if(mezoView.getMezo().getHoreteg() > 0)
                    addMoveMenupoint();

                // Nincs hó a mezõn, de van búvárruhája -> léphet
                else {
                    try {
                        aktivKarakter.keres(Targytipus.BUVARRUHA);
                        addMoveMenupoint();
                    } catch (ItemNotFoundException ignored) { }
                }

            // Nem lyuk -> biztos ráléphet
            } else addMoveMenupoint();
        }

        /*
         * Csak saját, nem lyuk mezõn elérhetõ opciók ezután
         */
        if(!mezoView.getMezo().equals(aktivKarakterMezo) || mezoView.getMezo().getClass().equals(Lyuk.class))
            return;

        // Van hó a mezõn -> áshat
        if(aktivKarakterMezo.getHoreteg() > 0)
            addDigMenuPoint();

        // Nincs hó a mezõn
        else {

            // Van tárgy a mezõn és nem fedi hó -> felveheti
            if (((Jegtabla) aktivKarakterMezo).getTargy() != null)
                addPickupItemMenuPoint();
        }

        // Kutató -> jeget nézhet
        if(aktivKarakter.tipus().equals(MozgathatoTipus.KUTATO))
            addCheckIceMenuPoint();

        // Már van épület -> mást már nem lehet építeni
        if(((Jegtabla) aktivKarakterMezo).getEpulet() != null) return;

        // Eszkimo -> építhet iglut
        if(aktivKarakter.tipus().equals(MozgathatoTipus.ESZKIMO))
            addBuildIgluMenuPoint();

        // Van sátra -> építhet sátrat
        try {
            aktivKarakter.keres(Targytipus.SATOR);
            addBuildTentMenuPoint();
        } catch (ItemNotFoundException ignored) { }
    }

    /**
     * A kutató képesség menüpont
     */
    private void addCheckIceMenuPoint(){

        JMenuItem check = new JMenuItem("Jeget néz");
        check.addActionListener((event) -> Controller.getInstance().jegetNez(mezoView.getMezo()));
        add(check);
    }

    /**
     * A körvége menüpont
     */
    private void addEndTurnMenuPoint(){

        JMenuItem endturn = new JMenuItem("Kör vége");
        Karakter source = Controller.getInstance().getActiveKarakter();
        endturn.addActionListener((event) -> Controller.getInstance().karakterKorvege(new KarakterKorvegeEvent(source)));
        add(endturn);
    }

    /**
     * A lépés menüpont
     */
    private void addMoveMenupoint(){

        JMenuItem move = new JMenuItem("Lép");
        move.addActionListener((event) -> Controller.getInstance().lep(mezoView.getMezo()));
        add(move);
    }

    /**
     * Az ásás menüpont
     */
    private void addDigMenuPoint() {

        JMenuItem dig = new JMenuItem("Ás");
        dig.addActionListener((event) -> Controller.getInstance().as());
        add(dig);
    }

    /**
     * A felvétel menüpont
     */
    private void addPickupItemMenuPoint() {

        JMenuItem pickup = new JMenuItem("Felvesz");
        pickup.addActionListener((event) -> Controller.getInstance().targyatFelvesz());
        add(pickup);
    }

    /**
     * Az eszkimó képsség menüpont
     */
    private void addBuildIgluMenuPoint() {

        JMenuItem build = new JMenuItem("Iglut épít");
        build.addActionListener((event) -> Controller.getInstance().iglutEpit());
        add(build);
    }

    /**
     * A sátorépítés menüpont
     */
    private void addBuildTentMenuPoint() {

        JMenuItem build = new JMenuItem("Sátrat épít");
        build.addActionListener((event) -> Controller.getInstance().satratEpit());
        add(build);
    }

    /**
     * A kombinálás menüpont
     */
    private void addCombineMenuPoint() {

        JMenuItem combine = new JMenuItem("Összeszerelés");
        combine.addActionListener((event) -> Controller.getInstance().osszeszerel());
        add(combine);
    }
}
