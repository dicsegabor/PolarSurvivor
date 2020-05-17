package SwingMVC.View;

import SwingMVC.Controller.Controller;

import javax.swing.*;
import java.awt.event.MouseEvent;


public class MezoMenu extends JPopupMenu {

    private MezoView mezoView;

    public MezoMenu(MezoView mezoView){

        super();
        this.mezoView = mezoView;
        addMoveMenupoint();
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
