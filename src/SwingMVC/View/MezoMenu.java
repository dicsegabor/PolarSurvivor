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

        // Csak szomsz�dos vagy saj�t mez�n
        if(!mezoView.getMezo().szomszedE(aktivKarakterMezo) &&
           !mezoView.getMezo().equals(aktivKarakterMezo))
            return;

        // �ssze tudj�k szerelni a jelz�pisztolyt -> ez legyen az els� opci�
        if(aktivKarakterMezo.tudnakEOsszeszerlni())
            addCombineMenuPoint();

        // Van b�v�rruha -> l�phet lyukra
        if(mezoView.getMezo().getClass().equals(Lyuk.class)){
            try {
                aktivKarakter.keres(Targytipus.BUVARRUHA);
                addMoveMenupoint();
                return;
            } catch (ItemNotFoundException e) { return; }
        }

        // Szomsz�dos mez� -> l�phet
        if(mezoView.getMezo().szomszedE(aktivKarakterMezo)) {
            addMoveMenupoint();
        }

        // Ezut�niakat csak saj�t mez�n csin�lhatja
        if(!mezoView.getMezo().equals(aktivKarakterMezo)) return;

        // Van h� a mez�n -> �shat
        if(aktivKarakterMezo.getHoreteg() > 0)
            addDigMenuPoint();
        else {
            // Van t�rgy a mez�n �s h� nincs -> felveheti
            if (((Jegtabla) aktivKarakterMezo).getTargy() != null)
                addPickupItemMenuPoint();
        }

        // Van s�tra -> �p�thet
        try {
            aktivKarakter.keres(Targytipus.SATOR);
            addBuildTentMenuPoint();
        } catch (ItemNotFoundException e) { }

        // Eszkimo -> �p�thet iglut
        if(aktivKarakter.tipus().equals(MozgathatoTipus.ESZKIMO))
            addBuildIgluMenuPoint();
    }

    private void addMoveMenupoint(){

        JMenuItem move = new JMenuItem("L�p");
        move.addActionListener((event) -> Controller.getInstance().lep(mezoView.getMezo()));
        add(move);
    }

    private void addDigMenuPoint() {

        JMenuItem dig = new JMenuItem("�s");
        dig.addActionListener((event) -> Controller.getInstance().as());
        add(dig);
    }

    private void addPickupItemMenuPoint() {

        JMenuItem pickup = new JMenuItem("Felvesz");
        pickup.addActionListener((event) -> Controller.getInstance().targyatFelvesz());
        add(pickup);
    }

    private void addBuildIgluMenuPoint() {

        JMenuItem build = new JMenuItem("Iglut �p�t");
        build.addActionListener((event) -> Controller.getInstance().iglutEpit());
        add(build);
    }

    private void addBuildTentMenuPoint() {

        JMenuItem build = new JMenuItem("S�trat �p�t");
        build.addActionListener((event) -> Controller.getInstance().satratEpit());
        add(build);
    }

    private void addCombineMenuPoint() {

        JMenuItem combine = new JMenuItem("�sszeszerel�s");
        combine.addActionListener((event) -> Controller.getInstance().osszeszerel());
        add(combine);
    }
}
