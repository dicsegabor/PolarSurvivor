package MVC.View.Game.Mezo;

import javafx.scene.Group;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class MezoView extends Group {
    private ArrayList<Rectangle> mozgathatok;
    private ArrayList<Rectangle> targyak;
    private Rectangle epulet;
    protected Pane mezo;
    protected BackgroundImage backgroundImage;

    public MezoView() {
        mozgathatok = new ArrayList<Rectangle>();
        targyak = new ArrayList<Rectangle>();
        mezo = new Pane();
        mezo.setPrefSize(200, 200);
    }

    public ArrayList<Rectangle> getMozgathatok() {
        return mozgathatok;
    }
}
