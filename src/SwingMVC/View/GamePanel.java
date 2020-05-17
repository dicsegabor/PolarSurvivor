package SwingMVC.View;

import Mezo.Mezo;
import Mezo.StabilJegtabla;
import Mozgathato.Eszkimo;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;
import Targy.Lapat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private static final Dimension DEFAULT_DIMENSION = new Dimension(1200, 1000);

    private ArrayList<MezoView> mezoViews;

    public GamePanel(){

        super();

        mezoViews = new ArrayList<>();

        setPreferredSize(DEFAULT_DIMENSION);
        setMinimumSize(DEFAULT_DIMENSION);
        setBackground(Color.BLACK);

        GridLayout layout = new GridLayout(5, 6);
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
