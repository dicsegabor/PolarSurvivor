package MVC.View.Game.Mezo;

import MVC.View.Game.Mozgathato.MozgathatoView;
import Mezo.Mezo;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import javax.imageio.ImageIO;
import java.util.ArrayList;

public abstract class MezoView extends Group {
    private ArrayList<MozgathatoView> mozgathatok;
    private ArrayList<Rectangle> targyak;
    private Rectangle epulet;
    protected Pane mezo;
    protected Image mezoImage;
    protected BackgroundImage backgroundImage;
    protected ContextMenu menu;
    private Mezo modelMezo;

    public MezoView(Mezo m) {
        mozgathatok = new ArrayList<>();
        targyak = new ArrayList<Rectangle>();
        mezo = new Pane();
        mezo.setPrefSize(200, 200);
        this.modelMezo = m;
    }

    public abstract void draw(Canvas canvas, int x, int y, double w, double h);

    public Mezo getModelMezo() { return modelMezo; }

    public abstract void showOptionsMenu(double x, double y, ArrayList<MenuItem> items);
    public void befogad(MozgathatoView m) {
        mozgathatok.add(m);
        this.getChildren().add(m);
    }
    public void kiad(MozgathatoView m) {
        mozgathatok.remove(m);
        this.getChildren().remove(m);
    }
    public ArrayList<MozgathatoView> getMozgathatok() {
        return mozgathatok;
    }
    public Pane getMezo() { return mezo; }
}
