package SwingMVC.View;

import SwingMVC.Controller.Controller;
import javafx.scene.control.Button;

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
        move.setMnemonic(MouseEvent.BUTTON1);
        move.addActionListener((event) -> Controller.getInstance().lep(mezoView.getMezo()));
        add(move);
    }
}
