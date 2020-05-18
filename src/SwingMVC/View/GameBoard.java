package SwingMVC.View;

import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;
import SwingMVC.Eventhandling.Events.*;
import Targy.Targy;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {

    private GamePanel gamePanel;
    private static JLabel statusLabel;

    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        gamePanel = new GamePanel();

        start();

        Controller.getInstance().addMezoEventListener(new MezoEventListener() {
            @Override
            public void atfordult(AtfordulasEvent event) {
                setStatusBarText();
            }

            @Override
            public void astak(AsasEvent event) {
                setStatusBarText();
            }

            @Override
            public void epites(EpitesEvent event) {
                setStatusBarText();
            }

            @Override
            public void kimentettek(KimentesEvent event) {
                setStatusBarText();
            }

            @Override
            public void kutatoKepesseg(KutatoKepessegEvent event) {
                setStatusBarText();
            }

            @Override
            public void leptek(LepesEvent event) {
                setStatusBarText();
            }

            @Override
            public void targyfelvetel(TargyfelvetelEvent event) {
                setStatusBarText();
            }

            @Override
            public void vihar(ViharEvent event) {
                setStatusBarText();
            }

            @Override
            public void targyhasznalat(TargyhasznalatEvent event) {
                setStatusBarText();
            }
        });
    }

    public void reset(){

        remove(gamePanel);
        gamePanel = new GamePanel();
        buildGUI();
    }

    public void hideGame(){

        gamePanel.setVisible(false);
    }

    private void setIcon(){

        ImageIcon img = new ImageIcon("Grafik�k\\Jegesmedve.png");
        setIconImage(img.getImage());
    }

    private void createStatusBar(){

        statusLabel = new JLabel();
        setStatusBarText();
        JPanel panel = new JPanel();

        panel.setVisible(true);
        add(statusLabel, BorderLayout.SOUTH);
    }

    public static void setStatusBarText() {

        int munka = Controller.getInstance().getActiveKarakter().getMunka();
        int testho = Controller.getInstance().getActiveKarakter().getTestho();

        StringBuilder targylista = new StringBuilder();

        for (Targy targy : Controller.getInstance().getActiveKarakter().getTargyak()) {

            targylista.append(targy.toString());
        }

        statusLabel.setText("Munka: " + munka + " | Testho: " + testho + " | Targyak: " + targylista);
    }

    private void createMenubar(){

        JMenuBar menuBar = new JMenuBar();

        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener((event) -> Controller.getInstance().restart());
        menuBar.add(restart);

        JMenuItem load = new JMenuItem("Load");
        menuBar.add(load);

        JMenuItem help = new JMenuItem("Help");
        menuBar.add(help);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((event) -> System.exit(0));
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
        createStatusBar();
        add(gamePanel,BorderLayout.CENTER);

        pack();
    }
}
