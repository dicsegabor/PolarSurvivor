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
 * A jobb klikk hat�s�ra el�ugr� men�, amivel a karaktereket ir�ny�thatjuk
 */
public class MezoMenu extends JPopupMenu {

    /**
     * T�rolja a hozz� tartoz� mezoViewt
     */
    private MezoView mezoView;

    public MezoMenu(MezoView mezoView){

        super();
        this.mezoView = mezoView;

        listSelectableMenuPoints();
    }

    /**
     * A t�rolt mezoView alapj�n, csak a relev�ns men�pontokat jelen�ti meg
     */
    private void listSelectableMenuPoints(){

        Karakter aktivKarakter = Controller.getInstance().getActiveKarakter();
        Mezo aktivKarakterMezo = aktivKarakter.getMezo();

        addEndTurnMenuPoint();

        // Csak szomsz�dos vagy saj�t mez�n
        if(!mezoView.getMezo().szomszedE(aktivKarakterMezo) &&
           !mezoView.getMezo().equals(aktivKarakterMezo))
            return;

        // �ssze tudj�k szerelni a jelz�pisztolyt
        if(mezoView.getMezo().equals(aktivKarakterMezo) && aktivKarakterMezo.tudnakEOsszeszerlni())
            addCombineMenuPoint();

        if(mezoView.getMezo().szomszedE(aktivKarakterMezo)) {
            // Kutat� szomsz�dos mez�n jeget n�z
            if(aktivKarakter.tipus().equals(MozgathatoTipus.KUTATO))
                addCheckIceMenuPoint();

            // Szomsz�dos mez�re l�p�s
            // Lyuk
            if(mezoView.getMezo().getClass().equals(Lyuk.class)){
                // Van rajta h� -> l�phet
                if(mezoView.getMezo().getHoreteg() > 0)
                    addMoveMenupoint();
                // Nincs h�, de van b�v�rruh�ja -> l�phet
                else {
                    try {
                        aktivKarakter.keres(Targytipus.BUVARRUHA);
                        addMoveMenupoint();
                    } catch (ItemNotFoundException ignored) { }
                }
            // Nem lyuk -> biztos l�phet
            } else addMoveMenupoint();
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

        // Kutato -> jeget n�zhet
        if(aktivKarakter.tipus().equals(MozgathatoTipus.KUTATO))
            addCheckIceMenuPoint();

        // M�r van �p�let -> m�st m�r nem lehet �p�teni
        if(((Jegtabla) aktivKarakterMezo).getEpulet() != null) return;

        // Eszkimo -> �p�thet iglut
        if(aktivKarakter.tipus().equals(MozgathatoTipus.ESZKIMO))
            addBuildIgluMenuPoint();

        // Van s�tra -> �p�thet
        try {
            aktivKarakter.keres(Targytipus.SATOR);
            addBuildTentMenuPoint();
        } catch (ItemNotFoundException ignored) { }
    }

    /**
     * A kutat� k�pess�g men�pont
     */
    private void addCheckIceMenuPoint(){

        JMenuItem check = new JMenuItem("Jeget n�z");
        check.addActionListener((event) -> Controller.getInstance().jegetNez(mezoView.getMezo()));
        add(check);
    }

    /**
     * A k�rv�ge men�pont
     */
    private void addEndTurnMenuPoint(){

        JMenuItem endturn = new JMenuItem("K�r v�ge");
        Karakter source = Controller.getInstance().getActiveKarakter();
        endturn.addActionListener((event) -> Controller.getInstance().karakterKorvege(new KarakterKorvegeEvent(source)));
        add(endturn);
    }

    /**
     * A l�p�s men�pont
     */
    private void addMoveMenupoint(){

        JMenuItem move = new JMenuItem("L�p");
        move.addActionListener((event) -> Controller.getInstance().lep(mezoView.getMezo()));
        add(move);
    }

    /**
     * Az �s�s men�pont
     */
    private void addDigMenuPoint() {

        JMenuItem dig = new JMenuItem("�s");
        dig.addActionListener((event) -> Controller.getInstance().as());
        add(dig);
    }

    /**
     * A felv�tel men�pont
     */
    private void addPickupItemMenuPoint() {

        JMenuItem pickup = new JMenuItem("Felvesz");
        pickup.addActionListener((event) -> Controller.getInstance().targyatFelvesz());
        add(pickup);
    }

    /**
     * Az eszkim� k�pss�g men�pont
     */
    private void addBuildIgluMenuPoint() {

        JMenuItem build = new JMenuItem("Iglut �p�t");
        build.addActionListener((event) -> Controller.getInstance().iglutEpit());
        add(build);
    }

    /**
     * A s�tor�p�t�s men�pont
     */
    private void addBuildTentMenuPoint() {

        JMenuItem build = new JMenuItem("S�trat �p�t");
        build.addActionListener((event) -> Controller.getInstance().satratEpit());
        add(build);
    }

    /**
     * A kombin�l�s men�pont
     */
    private void addCombineMenuPoint() {

        JMenuItem combine = new JMenuItem("�sszeszerel�s");
        combine.addActionListener((event) -> Controller.getInstance().osszeszerel());
        add(combine);
    }
}
