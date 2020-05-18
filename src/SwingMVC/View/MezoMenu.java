package SwingMVC.View;

import Exceptions.ItemNotFoundException;
import Mezo.*;
import Mozgathato.Karakter;
import Mozgathato.MozgathatoTipus;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.KarakterKorvegeEvent;
import Targy.Targytipus;

import javax.swing.*;

public class MezoMenu extends JPopupMenu {

    private MezoView mezoView;

    public MezoMenu(MezoView mezoView){

        super();
        this.mezoView = mezoView;

        listSelectableMenuPoints();
    }

    private void listSelectableMenuPoints(){

        Karakter aktivKarakter = Controller.getInstance().getActiveKarakter();
        Mezo aktivKarakterMezo = aktivKarakter.getMezo();

        addEndTurnMenuPoint();

        // Csak szomszédos vagy saját mezõn
        if(!mezoView.getMezo().szomszedE(aktivKarakterMezo) &&
           !mezoView.getMezo().equals(aktivKarakterMezo))
            return;

        // Össze tudják szerelni a jelzõpisztolyt
        if(mezoView.getMezo().equals(aktivKarakterMezo) && aktivKarakterMezo.tudnakEOsszeszerlni())
            addCombineMenuPoint();

        if(mezoView.getMezo().szomszedE(aktivKarakterMezo)) {
            // Kutató szomszédos mezõn jeget néz
            if(aktivKarakter.tipus().equals(MozgathatoTipus.KUTATO))
                addCheckIceMenuPoint();

            // Szomszédos mezõre lépés
            // Lyuk
            if(mezoView.getMezo().getClass().equals(Lyuk.class)){
                // Van rajta hó -> léphet
                if(mezoView.getMezo().getHoreteg() > 0)
                    addMoveMenupoint();
                // Nincs hó, de van búvárruhája -> léphet
                else {
                    try {
                        aktivKarakter.keres(Targytipus.BUVARRUHA);
                        addMoveMenupoint();
                    } catch (ItemNotFoundException e) { }
                }
            // Nem lyuk -> biztos léphet
            } else addMoveMenupoint();
        }

        // Ezutániakat csak saját mezõn csinálhatja
        if(!mezoView.getMezo().equals(aktivKarakterMezo)) return;

        // Van hó a mezõn -> áshat
        if(aktivKarakterMezo.getHoreteg() > 0)
            addDigMenuPoint();
        else {
            // Van tárgy a mezõn és hó nincs -> felveheti
            if (((Jegtabla) aktivKarakterMezo).getTargy() != null)
                addPickupItemMenuPoint();
        }

        // Kutato -> jeget nézhet
        if(aktivKarakter.tipus().equals(MozgathatoTipus.KUTATO))
            addCheckIceMenuPoint();

        // Már van épület -> mást már nem lehet építeni
        if(((Jegtabla) aktivKarakterMezo).getEpulet() != null) return;

        // Eszkimo -> építhet iglut
        if(aktivKarakter.tipus().equals(MozgathatoTipus.ESZKIMO))
            addBuildIgluMenuPoint();

        // Van sátra -> építhet
        try {
            aktivKarakter.keres(Targytipus.SATOR);
            addBuildTentMenuPoint();
        } catch (ItemNotFoundException e) { }
    }

    private void addCheckIceMenuPoint(){

        JMenuItem check = new JMenuItem("Jeget néz");
        check.addActionListener((event) -> Controller.getInstance().jegetNez(mezoView.getMezo()));
        add(check);
    }

    private void addEndTurnMenuPoint(){

        JMenuItem endturn = new JMenuItem("Kör vége");
        Karakter source = Controller.getInstance().getActiveKarakter();
        endturn.addActionListener((event) -> Controller.getInstance().karakterKorvege(new KarakterKorvegeEvent(source)));
        add(endturn);
    }

    private void addMoveMenupoint(){

        JMenuItem move = new JMenuItem("Lép");
        move.addActionListener((event) -> Controller.getInstance().lep(mezoView.getMezo()));
        add(move);
    }

    private void addDigMenuPoint() {

        JMenuItem dig = new JMenuItem("Ás");
        dig.addActionListener((event) -> Controller.getInstance().as());
        add(dig);
    }

    private void addPickupItemMenuPoint() {

        JMenuItem pickup = new JMenuItem("Felvesz");
        pickup.addActionListener((event) -> Controller.getInstance().targyatFelvesz());
        add(pickup);
    }

    private void addBuildIgluMenuPoint() {

        JMenuItem build = new JMenuItem("Iglut épít");
        build.addActionListener((event) -> Controller.getInstance().iglutEpit());
        add(build);
    }

    private void addBuildTentMenuPoint() {

        JMenuItem build = new JMenuItem("Sátrat épít");
        build.addActionListener((event) -> Controller.getInstance().satratEpit());
        add(build);
    }

    private void addCombineMenuPoint() {

        JMenuItem combine = new JMenuItem("Összeszerelés");
        combine.addActionListener((event) -> Controller.getInstance().osszeszerel());
        add(combine);
    }
}
