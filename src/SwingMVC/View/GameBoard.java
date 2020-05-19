package SwingMVC.View;

import SwingMVC.Controller.Controller;
import SwingMVC.Model.MapGenerator;
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
 * MEgjelenít egy menüszallagot, valamint a karakter statusbar-ját.
 */
public class GameBoard extends JFrame {

    /**
     * A panel, ami a mezõk grafikus megjelenítését tárolja.
     * Tárolja a mezõn található entitások megjelenítését is.
     */
    private GamePanel gamePanel;

    /**
     * Az aktív karakter tulajdonságait megjelenítõ állapotsáv.
     */
    private JPanel statusBar;

    /**
     * Az aktív karakter tulajdonságait megjelenítõ állapotsávban a szöveg.
     */
    private JLabel statusLabel;

    public GameBoard(){

        //Beállítjuk az alapvetõ dolgokat
        super("Polar Survivor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        //Beálllítjuk a gamePanelt
        gamePanel = new GamePanel();
    }

    /**
     * Visszaállítja a gamePanel-t az eredeti állapotába
     * (vagy új random pálát generáltat vele)
     */
    public void reset(){

        //Kitöröljük a régi objektumokat
        remove(gamePanel);
        remove(statusBar);

        //Új objektumot töltünk be
        gamePanel = new GamePanel();
        buildGUI();
    }

    /**
     * Elrejti az aktuális játékot, hogy ne lehessen katintgatni.
     * Ez csak a játék végén hívjuk meg, hog nem maradjon ott a befejezetlen játék.
     */
    public void hideGame(){

        gamePanel.setVisible(false);
    }

    /**
     * Kiemeli az aktív karaktert.
     * Kicseréli az aktív karakter képét egy kijelölt karakter képre.
     */
    public void highlightKarakter() {

        gamePanel.highlightKarakter();
    }

    /**
     * Megszünteti az aktív karakter kiemelését.
     * Kicseréli a kijelölt aktív karakter képét egy nem kijelöltre.
     */
    public void removeHighlightKarakter(){

        gamePanel.removeHighlightKarakter();
    }

    /**
     * Létrehozza az állapotsávot és az elemeit, valamint hozzáadja.
     */
    private void createStatusBar(){

        //Tárolók létrehozása
        statusBar = new JPanel();
        statusLabel = new JLabel();

        //Beállítjuk a szöveget
        setStatusBarText();
        statusBar.add(statusLabel);
        statusBar.setVisible(true);

        //Hozzáadjuk a JFrame-hez
        add(statusBar, BorderLayout.SOUTH);
    }

    /**
     * Az állaptosávban található adatokat lekrdezi és belerakja az állapotsávba
     */
    public void setStatusBarText() {

        //Lekérdezzük a munnkát és a testhõt az aktív karaktertõl
        int munka = Controller.getInstance().getActiveKarakter().getMunka();
        int testho = Controller.getInstance().getActiveKarakter().getTestho();

        StringBuilder targylista = new StringBuilder();

        //Lekérdezzük a tárgylistát
        for (Targy targy : Controller.getInstance().getActiveKarakter().getTargyak())
            targylista.append(targy.tipus());

        statusLabel.setText(Controller.getInstance().getActiveKarakter().tipus() + " || Munka: " + munka + " | Testho: " + testho + " | Targyak: " + targylista);
    }

    /**
     * Létrehozza a menüsort és elemeit,
     * valamint beállítja azok viselkedését
     */
    private void createMenubar(){

        JMenuBar menuBar = new JMenuBar();

        //Reload map gomb létrehozása
        JMenuItem restart = new JMenuItem("Reload map");
        //Meghívja a Controller restart függvényét
        restart.addActionListener((event) -> Controller.getInstance().restart());
        menuBar.add(restart);

        //A map menü létrehozása
        JMenu map = new JMenu("Map");
        menuBar.add(map);

        //Load default map meüpont létrehozása
        JMenuItem loadDefault = new JMenuItem("Load default map");
        loadDefault.addActionListener((event) -> {Controller.getInstance().setMap(false); Controller.getInstance().restart();});
        map.add(loadDefault);

        //Random generated map meüpont létrehozása
        JMenuItem generate = new JMenuItem("Random generated map");
        generate.addActionListener((event) -> {Controller.getInstance().setMap(true); Controller.getInstance().restart();});
        map.add(generate);

        //Set generato meüpont létrehozása
        JMenuItem setGenerator = new JMenuItem("Set generator");
        //Létrehozza a set generator dialog
        setGenerator.addActionListener((event) -> createGeneratorInputDialog());
        map.add(setGenerator);

        //Help meüpont létrehozása
        JMenuItem help = new JMenuItem("Help");
        //Létrehozza a helpdialogot
        help.addActionListener((event) -> createHelpDialog());
        menuBar.add(help);

        //Exit meüpont létrehozása
        JMenuItem exit = new JMenuItem("Exit");
        //Kilép az alkalmazásból
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

        //Beolvasáshoz felveszünk 2 textfieldet, és beleírjuk a jelenlegi értékeket
        JTextField researcherCount = new JTextField(Integer.toString(MapGenerator.researcherCount));
        JTextField eskimoCount = new JTextField(Integer.toString(MapGenerator.eskimoCount));
        JCheckBox polarBear = new JCheckBox("", MapGenerator.polarBear);
        //Advance settings gom létrehozása
        JButton advanced = new JButton("Show advanced");
        advanced.addActionListener(e -> createAdvancedGeneratorSettings());

        Object[] message = {

                "Kutatok szama", researcherCount,
                "Eszkimok szama", eskimoCount,
                "Jegesmedve", polarBear,
                advanced
        };

        //Az optionpane megjelenítése, valamint kiértékelése
        int option = JOptionPane.showConfirmDialog(this, message, "Set generator", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
            MapGenerator.setGenerator(Integer.parseInt(researcherCount.getText()), Integer.parseInt(eskimoCount.getText()), polarBear.isSelected());
    }

    /**
     * Letrehozza azt az inputDialog-ot, ahol a generator további beállításait állíthatjuk
     */
    private void createAdvancedGeneratorSettings(){

        JTextField holeRatio = new JTextField(Integer.toString(MapGenerator.HOLE));
        JTextField unstableRatio = new JTextField(Integer.toString(MapGenerator.UNSTABLE));
        JTextField stableRatio = new JTextField(Integer.toString(MapGenerator.STABLE));
        JTextField holeCoverageRatio = new JTextField(Integer.toString(MapGenerator.HOLE_COVERAGE));
        JTextField itemRatio = new JTextField(Integer.toString(MapGenerator.ITEM_CHANCE));

        Object[] message = {

                "Lyuk esely", holeRatio,
                "Instabil esely", unstableRatio,
                "Stabil esely", stableRatio,
                "Lyuk lefedettseg esely", holeCoverageRatio,
                "Targy esely", itemRatio
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Set generator", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION){

            MapGenerator.HOLE = Integer.parseInt(holeRatio.getText());
            MapGenerator.UNSTABLE = Integer.parseInt(unstableRatio.getText());
            MapGenerator.STABLE = Integer.parseInt(stableRatio.getText());
            MapGenerator.HOLE_COVERAGE = Integer.parseInt(holeCoverageRatio.getText());
            MapGenerator.ITEM_CHANCE = Integer.parseInt(itemRatio.getText());
        }
    }

    /**
     * Letrehozza a dialog-ot, amiben  kiirjuk a help szöveget
     */
    private void createHelpDialog(){

        //Lekérdezzük a help.txt helyét
        URL url = getClass().getResource("Help.txt");
        //beolvassuk a fájlt
        String text = "";
        try(InputStream in = url.openStream()){

            byte[] bytes = in.readAllBytes();
            text = new String(bytes, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //Betöltjük a szöveget a textareaban
        JTextArea textArea = new JTextArea(text);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize( new Dimension( 700, 600 ) );
        //kirajzoljuk az optionpane-t
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
