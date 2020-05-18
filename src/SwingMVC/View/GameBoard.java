package SwingMVC.View;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {

    private GamePanel gamePanel;

    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TODO: menüsáv jó elrakása
        //setLayout(new GridLayout(3, 1));

        //TODO: Menüsáv
        JMenuBar menuBar = new JMenuBar();
        add(menuBar);

        gamePanel = new GamePanel();

        //TODO:karaktertul

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
