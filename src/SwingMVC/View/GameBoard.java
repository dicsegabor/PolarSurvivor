package SwingMVC.View;

import SwingMVC.Controller.Controller;
import Targy.Targy;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JFrame {

    private GamePanel gamePanel;
    private JLabel label;
    private JPanel panel;

    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //kozep
        gamePanel = new GamePanel();

        //also
        int munka=Controller.getInstance().getActiveKarakter().getMunka();
        int testho=Controller.getInstance().getActiveKarakter().getTestho();
        List<Targy> targyak = new ArrayList<Targy>();
        targyak.addAll(Controller.getInstance().getActiveKarakter().getTargyak());
        String targylista="";
        for (Targy targy:targyak)
        {
            targylista+=targy.toString();
        }
        label=new JLabel();
        panel=new JPanel();
        label.setText("Munka: "+Integer.toString(munka)+" Testho: "+Integer.toString(testho)+", Targyak: "+targylista);
        panel.setVisible(true);
        add(panel);

        start();
    }

    private void createMenubar(){

        JMenuBar menuBar = new JMenuBar();

        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener((event) -> Controller.getInstance().restart());
        menuBar.add(restart);

        JMenuItem load=new JMenuItem("Load");
        menuBar.add(load);

        JMenuItem help=new JMenuItem("Help");
        menuBar.add(help);

        JMenuItem exit=new JMenuItem("Exit");
        menuBar.add(exit);

        menuBar.setVisible(true);

        add(menuBar,BorderLayout.NORTH);
    }

    public void start(){

        setVisible(true);
        buildGUI();
    }

    private void buildGUI() {

        createMenubar();
        add(gamePanel,BorderLayout.CENTER);
        add(label,BorderLayout.SOUTH);
        pack();
    }
}
