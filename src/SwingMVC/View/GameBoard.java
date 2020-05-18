package SwingMVC.View;

import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;
import SwingMVC.Eventhandling.Events.*;
import Targy.Targy;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {

    private GamePanel gamePanel;
    private JLabel statusLabel;
    public boolean randomMap;

    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        gamePanel = new GamePanel();
    }

    public void reset(){

        remove(gamePanel);
        gamePanel = new GamePanel();
        buildGUI();
    }

    public void hideGame(){

        gamePanel.setVisible(false);
    }

    public void highlightKarakter() {

        gamePanel.highlightKarakter();
    }

    public void removeHighlightKarakter(){

        gamePanel.removeHighlightKarakter();
    }

    private void createStatusBar(){

        statusLabel = new JLabel();
        setStatusBarText();
        JPanel panel = new JPanel();
        panel.add(statusLabel);
        panel.setVisible(true);
        add(panel, BorderLayout.SOUTH);
    }

    public void setStatusBarText() {

        int munka = Controller.getInstance().getActiveKarakter().getMunka();
        int testho = Controller.getInstance().getActiveKarakter().getTestho();

        StringBuilder targylista = new StringBuilder();

        for (Targy targy : Controller.getInstance().getActiveKarakter().getTargyak()) {

            targylista.append(targy.tipus());
        }

        statusLabel.setText(Controller.getInstance().getActiveKarakter().tipus() + " || Munka: " + munka + " | Testho: " + testho + " | Targyak: " + targylista);
    }

    private void createMenubar(){

        JMenuBar menuBar = new JMenuBar();

        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener((event) -> Controller.getInstance().restart());
        menuBar.add(restart);

        JMenu map = new JMenu("Map");
        menuBar.add(map);

        JMenuItem loadDefault = new JMenuItem("Load default map");
        loadDefault.addActionListener((event) -> {Controller.getInstance().setMap(false); Controller.getInstance().restart();});
        map.add(loadDefault);

        JMenuItem generate = new JMenuItem("Random generated map");
        generate.addActionListener((event) -> {Controller.getInstance().setMap(true); Controller.getInstance().restart();});
        map.add(generate);

        JMenuItem help = new JMenuItem("Help");
        menuBar.add(help);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((event) -> System.exit(0));
        menuBar.add(exit);

        menuBar.setLayout(new GridLayout(1, 4));
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
