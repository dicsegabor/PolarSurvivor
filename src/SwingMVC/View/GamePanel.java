package SwingMVC.View;

import Mezo.StabilJegtabla;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private static Dimension DEFAULT_DIMENSION = new Dimension(800, 600);

    private ArrayList<MezoView> mezoViews;

    public GamePanel(){

        super();

        mezoViews = new ArrayList<>();

        setPreferredSize(DEFAULT_DIMENSION);
        setMinimumSize(DEFAULT_DIMENSION);
        setBackground(Color.BLACK);

        setVisible(true);
    }

    private void addMezoView(MezoView mezoView){

        mezoViews.add(mezoView);
        add(mezoView);
    }
}
