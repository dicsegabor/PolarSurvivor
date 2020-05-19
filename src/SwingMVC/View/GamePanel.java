package SwingMVC.View;

import Mezo.Mezo;
import SwingMVC.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Tárolja a mezõkhöz tartozó mezoView-kat, és gondoskodik az elrendezésükrõl
 */
public class GamePanel extends JPanel {

    /**
     * Tarolja a játéktér alapméretét
     */
    public static final Dimension DEFAULT_DIMENSION = new Dimension(840, 700);

    /**
     * Tárolja a mezõkhöz tartozó mezoView-kat
     */
    private ArrayList<MezoView> mezoViews;

    /**
     * Beállítja a panel tulajdonságait, valamint feltölti  mezoView listát a model alapján
     * Kiemeli a kezdõ karaktert
     */
    public GamePanel(){

        super();

        mezoViews = new ArrayList<>();

        setPreferredSize(DEFAULT_DIMENSION);
        setMinimumSize(DEFAULT_DIMENSION);
        setBackground(Color.BLACK);

        GridLayout layout = new GridLayout(5, 6);
        setLayout(layout);

        for(Mezo m : Controller.getInstance().getModel().getMezok())
            addMezoView(new MezoView(m));

        highlightKarakter();

        setVisible(true);
    }

    /**
     * Kiemeli az aktív karaktert
     */
    public void highlightKarakter() {

        for (MezoView mv : mezoViews)
            if(mv.containsEntity(Controller.getInstance().getActiveKarakter()))
                mv.highlightKarakter(Controller.getInstance().getActiveKarakter());
    }

    /**
     * Megszünteti az aktív karakter kiemelését
     */
    public void removeHighlightKarakter(){

        for (MezoView mv : mezoViews)
            if(mv.containsEntity(Controller.getInstance().getActiveKarakter()))
                mv.removeHighlightKarakter(Controller.getInstance().getActiveKarakter());
    }

    /**
     * Hozzáadja a paraméterként kapo mezoView-t a listához, valamint a panlehez
     * @param mezoView
     */
    private void addMezoView(MezoView mezoView){

        mezoViews.add(mezoView);
        add(mezoView);
    }
}
