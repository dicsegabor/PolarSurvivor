package SwingMVC.View;

import Mezo.Mezo;
import SwingMVC.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private static final Dimension DEFAULT_DIMENSION = new Dimension(936, 780);

    private ArrayList<MezoView> mezoViews;

    public GamePanel(){

        super();

        mezoViews = new ArrayList<>();

        setPreferredSize(DEFAULT_DIMENSION);
        setMinimumSize(DEFAULT_DIMENSION);
        setBackground(Color.BLACK);

        GridLayout layout = new GridLayout(5, 6);
        layout.setVgap(1);
        layout.setHgap(1);
        setLayout(layout);

        for(Mezo m : Controller.getInstance().getModel().getMezok())
            addMezoView(new MezoView(m));

        setVisible(true);
    }

    private void addMezoView(MezoView mezoView){

        mezoViews.add(mezoView);
        add(mezoView);
    }
}
