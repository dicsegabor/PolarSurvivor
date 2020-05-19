package SwingMVC.View;

import SwingMVC.Controller.Controller;
import SwingMVC.Model.MapGenerator;
import SwingMVC.Model.Model;
import Targy.Targy;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Ez az osztály felelõs a program megjelenítéséért.
 * Egy JFrame-bõl származik, tehát ez tárol minden mást.
 */
public class GameBoard extends JFrame {

    /**
     * A panel, ami a mezõk grafikus megjelenítését tárolja.
     */
    private GamePanel gamePanel;

    /**
     * Az aktív karakter tulajdonságait megjelenítõ állapotsáv.
     */
    private JLabel statusLabel;

    public GameBoard(){

        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        gamePanel = new GamePanel();
    }

    /**
     * Visszaállítja a gamePanel-t az eredeti állapotába
     * (vagy új random pálát generáltat vele)
     */
    public void reset(){

        remove(gamePanel);
        gamePanel = new GamePanel();
        buildGUI();
    }

    /**
     * Elrejti az aktuális játékot, hogy ne lehessen katintgatni
     */
    public void hideGame(){

        gamePanel.setVisible(false);
    }

    /**
     * Kiemeli az aktyv karaktert
     */
    public void highlightKarakter() {

        gamePanel.highlightKarakter();
    }

    /**
     * Megszünteti az aktív karakter kiemelését
     */
    public void removeHighlightKarakter(){

        gamePanel.removeHighlightKarakter();
    }

    /**
     * Létrehozza az állapotsávot és az elemeit
     */
    private void createStatusBar(){

        statusLabel = new JLabel();
        setStatusBarText();
        JPanel panel = new JPanel();
        panel.add(statusLabel);
        panel.setVisible(true);
        add(panel, BorderLayout.SOUTH);
    }

    /**
     * Az állaptosávban található adatokat lekrdezi és belerakja az állapotsávba
     */
    public void setStatusBarText() {

        int munka = Controller.getInstance().getActiveKarakter().getMunka();
        int testho = Controller.getInstance().getActiveKarakter().getTestho();

        StringBuilder targylista = new StringBuilder();

        for (Targy targy : Controller.getInstance().getActiveKarakter().getTargyak()) {

            targylista.append(targy.tipus());
        }

        statusLabel.setText(Controller.getInstance().getActiveKarakter().tipus() + " || Munka: " + munka + " | Testho: " + testho + " | Targyak: " + targylista);
    }

    /**
     * Létrehozza a menüsort és elemeit,
     * valamint beállítja azok viselkedését
     */
    private void createMenubar(){

        JMenuBar menuBar = new JMenuBar();

        JMenuItem restart = new JMenuItem("Reload map");
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

        JMenuItem setGenerator = new JMenuItem("Set generator");
        setGenerator.addActionListener((event) -> createGeneratorInputDialog());
        map.add(setGenerator);

        JMenuItem help = new JMenuItem("Help");
        help.addActionListener((event) -> createHelpDialog());
        menuBar.add(help);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((event) -> System.exit(0));
        menuBar.add(exit);

        menuBar.setLayout(new GridLayout(1, 4));
        menuBar.setVisible(true);

        add(menuBar,BorderLayout.NORTH);
    }

    /**
     * Létrehozza az Inputdialog-ot, amiben beállíthatjuk a pályagenerátor adatait
     */
    private void createGeneratorInputDialog(){

        JTextField researcherCount = new JTextField(Integer.toString(MapGenerator.researcherCount));
        JTextField eskimoCount = new JTextField(Integer.toString(MapGenerator.eskimoCount));
        JCheckBox polarBear = new JCheckBox("", MapGenerator.polarBear);
        Object[] message = {

                "Kutatok szama:", researcherCount,
                "Eszkimok szama", eskimoCount,
                "Jegesmedve", polarBear
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Set generator", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
            MapGenerator.setGenerator(Integer.parseInt(researcherCount.getText()), Integer.parseInt(eskimoCount.getText()), polarBear.isSelected());
    }

    /**
     * Letrehozza a dialog-ot, amiben  kiirjuk a help szöveget
     */
    private void createHelpDialog(){

        URL url = getClass().getResource("Help.txt");
        String text = "";
        try(InputStream in = url.openStream()){

            byte[] bytes = in.readAllBytes();
            //TODO: Kitalálni a kódolást, mert így nem jó
            text = new String(bytes, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        JTextArea textArea = new JTextArea(text);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize( new Dimension( 500, 600 ) );
        JOptionPane.showMessageDialog(this, scrollPane, "Help", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Ezzel a metódussal lehet elindítani a játékot.
     * Láthatóvá tesi, valamint felépíti a GUI-t.
     */
    public void start(){

        setVisible(true);
        buildGUI();
    }

    /**
     * Felépíti a GUI-t;
     */
    private void buildGUI() {

        createMenubar();
        createStatusBar();
        add(gamePanel,BorderLayout.CENTER);

        pack();
    }
}
