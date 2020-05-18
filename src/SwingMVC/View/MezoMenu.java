package SwingMVC.View;

import Exceptions.ItemNotFoundException;
import Mezo.*;
import Mozgathato.Eszkimo;
import Mozgathato.Karakter;
import Mozgathato.MozgathatoTipus;
import SwingMVC.Controller.Controller;
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

        // Csak szomszédos vagy saját mezõn
        if(!mezoView.getMezo().szomszedE(aktivKarakterMezo) &&
           !mezoView.getMezo().equals(aktivKarakterMezo))
            return;

        // Össze tudják szerelni a jelzõpisztolyt -> ez legyen az elsõ opció
        if(aktivKarakterMezo.tudnakEOsszeszerlni())
            addCombineMenuPoint();

        // Van búvárruha -> léphet lyukra
        if(mezoView.getMezo().getClass().equals(Lyuk.class)){
            try {
                aktivKarakter.keres(Targytipus.BUVARRUHA);
                addMoveMenupoint();
                return;
            } catch (ItemNotFoundException e) { return; }
        }

        // Szomszédos mezõ -> léphet
        if(mezoView.getMezo().szomszedE(aktivKarakterMezo)) {
            addMoveMenupoint();
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

        // Van sátra -> építhet
        try {
            aktivKarakter.keres(Targytipus.SATOR);
            addBuildTentMenuPoint();
        } catch (ItemNotFoundException e) { }

        // Eszkimo -> építhet iglut
        if(aktivKarakter.tipus().equals(MozgathatoTipus.ESZKIMO))
            addBuildIgluMenuPoint();
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
