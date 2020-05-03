package MVC.View.Game.Mezo;

import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class MezoView extends StackPane {
    private ArrayList<Rectangle> mozgathatok;
    private ArrayList<Rectangle> targyak;
    private Rectangle epulet;
    protected Pane mezo;
    protected BackgroundImage backgroundImage;
    protected ContextMenu menu;

    public MezoView() {
        mozgathatok = new ArrayList<Rectangle>();
        targyak = new ArrayList<Rectangle>();
        mezo = new Pane();
        mezo.setPrefSize(200, 200);
    }

    public abstract void showOptionsMenu(double x, double y, ArrayList<MenuItem> items);

    public ArrayList<Rectangle> getMozgathatok() {
        return mozgathatok;
    }
    public Pane getMezo() { return mezo; }
}
