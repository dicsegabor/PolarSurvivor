package SwingMVC.View;

import Mezo.Mezo;
import Mezo.StabilJegtabla;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.AtfordulasEventListener;
import SwingMVC.Eventhandling.Events.AtfordulasEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

        /*GridLayout layout = new GridLayout();
        layout.setColumns(3);
        layout.setRows(3);
        layout.setHgap(5);
        layout.setVgap(5);
        setLayout(layout);*/

        StabilJegtabla jegtabla = new StabilJegtabla();
        MezoView mezoView = new MezoView(jegtabla);

        mezoView.setBackgroundImage("Grafikák\\stable ice.png");
        addMezoView(mezoView);

        addAtfordulasListener();
        addListener(jegtabla);

        setVisible(true);
    }

    private void addMezoView(MezoView mezoView){

        mezoViews.add(mezoView);
        add(mezoView);
    }

    private void addAtfordulasListener(){

        AtfordulasEventListener atfordulasEventListener = event -> {

            for(MezoView mv : mezoViews)
                if(mv.getMezo().equals(event.getSource()))
                    mv.setBackgroundImage("Grafikák\\Unstable ice.png");
        };

        Controller.getInstance().addListener(atfordulasEventListener);
    }

    private void addListener(StabilJegtabla jegtabla){

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e))
                    Controller.getInstance().fireEvent(new AtfordulasEvent(jegtabla));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
