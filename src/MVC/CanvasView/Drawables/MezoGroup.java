package MVC.CanvasView.Drawables;

import MVC.CanvasView.Drawable;
import Mezo.Mezo;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class MezoGroup extends Drawable {
    protected Canvas canvas;
    protected Mezo model;
    protected double size;
    protected ArrayList<Drawable> mozgathatok;

    public MezoGroup(int size, Mezo model, String imageFileName) {
        super(imageFileName);
        this.model = model;
        this.size = size;
        mozgathatok = new ArrayList<>();
        canvas = new Canvas(size, size);
        loadImage(imageFileName);
    }

    public ArrayList<Drawable> getMozgathatok() { return mozgathatok; }

    public Canvas getCanvas() { return canvas; }

    public abstract void draw();
}
