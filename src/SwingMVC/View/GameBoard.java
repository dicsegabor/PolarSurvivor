package SwingMVC.View;

import javax.swing.*;

public class GameBoard extends JFrame {

    private GamePanel gamePanel;

    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        JMenuBar menuBar = new JMenuBar();
        add(menuBar);

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
