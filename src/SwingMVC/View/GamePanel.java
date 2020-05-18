package SwingMVC.View;

import Mezo.Mezo;
import SwingMVC.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    public static final Dimension DEFAULT_DIMENSION = new Dimension(840, 700);

    private ArrayList<MezoView> mezoViews;

    public GamePanel(boolean isRandom){

        super();

        mezoViews = new ArrayList<>();

        setPreferredSize(DEFAULT_DIMENSION);
        setMinimumSize(DEFAULT_DIMENSION);
        setBackground(Color.BLACK);

        GridLayout layout = new GridLayout(5, 6);
        setLayout(layout);

        if(isRandom)
            for(Mezo m : Controller.getInstance().getModel().generateRandomMap())
                addMezoView(new MezoView(m));

        else
            for(Mezo m : Controller.getInstance().getModel().getMezok())
                addMezoView(new MezoView(m));

        highlightKarakter();

        setVisible(true);
    }

    public void highlightKarakter() {

        for (MezoView mv : mezoViews)
            if(mv.containsEntity(Controller.getInstance().getActiveKarakter()))
                mv.highlightKarakter(Controller.getInstance().getActiveKarakter());
    }

    public void removeHighlightKarakter(){

        for (MezoView mv : mezoViews)
            if(mv.containsEntity(Controller.getInstance().getActiveKarakter()))
                mv.removeHighlightKarakter(Controller.getInstance().getActiveKarakter());
    }

    private void addMezoView(MezoView mezoView){

        mezoViews.add(mezoView);
        add(mezoView);
    }
}
