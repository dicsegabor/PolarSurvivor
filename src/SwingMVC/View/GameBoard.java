package SwingMVC.View;

import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.AtfordulasEventListener;
import SwingMVC.Eventhandling.Events.AtfordulasEvent;

import javax.swing.*;

public class GameBoard extends JFrame {

    private GamePanel gamePanel;

    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();

        start();
    }

    public void start(){

        setVisible(true);
        buildGUI();
    }

    private void buildGUI() {

        add(gamePanel);
        pack();
    }
}
