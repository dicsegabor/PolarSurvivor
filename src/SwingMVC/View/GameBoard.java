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
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem restart;
    private JMenuItem exit;
    private JMenuItem load;
    private JMenuItem help;
    //exit
    //betoltes
    //jelmagyarazat
    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //felso
        menuBar = new JMenuBar();
        menu=new JMenu("Menu");
        restart=new JMenuItem("Restart");
        menu.add(restart);
        load=new JMenuItem("Load");
        menu.add(load);
        help=new JMenuItem("Help");
        menu.add(help);
        exit=new JMenuItem("Exit");
        menu.add(exit);
        menuBar.add(menu);
        menuBar.setVisible(true);
        add(menuBar);



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

    public void start(){

        setVisible(true);
        buildGUI();
    }

    private void buildGUI() {

        add(menuBar,BorderLayout.NORTH);
        add(gamePanel,BorderLayout.CENTER);
        add(label,BorderLayout.SOUTH);
        pack();
    }
}
