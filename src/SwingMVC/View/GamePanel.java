package SwingMVC.View;

import Mezo.StabilJegtabla;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private static Dimension DEFAULT_DIMENSION = new Dimension(800, 600);

    public GamePanel(){

        super();
        setPreferredSize(DEFAULT_DIMENSION);
        setMinimumSize(DEFAULT_DIMENSION);
        setBackground(Color.BLACK);
        GridLayout layout = new GridLayout();
        layout.setColumns(3);
        layout.setRows(3);
        layout.setHgap(5);
        layout.setVgap(5);
        setLayout(layout);

        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));
        add(new MezoView(new StabilJegtabla()));


        setVisible(true);
    }
}
