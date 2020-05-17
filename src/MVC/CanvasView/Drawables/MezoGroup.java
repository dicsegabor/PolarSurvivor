package MVC.CanvasView.Mezo;

import MVC.CanvasView.Drawable;
import Mezo.Mezo;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class MezoGroup extends Drawable {
    private Canvas canvas;
    private Mezo model;
    private double x, y, size;
    private int horeteg;
    private Drawable epulet;
    private Drawable targy;
    private ArrayList<Drawable> mozgathatok;

    public MezoGroup(int size, Mezo model, String imageFileName) {
        super(imageFileName);
        this.model = model;
        canvas = new Canvas(size, size);
    }

    public void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.drawImage(this.image, x, y, size, size);

        if(model.getHoreteg() > 0)
            g.drawImage(new Ho("ho.png").getDrawable(), x, y, size, size);
    }
}
