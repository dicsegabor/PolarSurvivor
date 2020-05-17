package MVC.CanvasView.Drawables;

import MVC.View.Resources.ResourceProvider;
import Mezo.Mezo;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class StabilJegtablaGroup extends MezoGroup {
    private Image targy;
    private Image epulet;

    public StabilJegtablaGroup(int size, Mezo model) {
        super(size, model, "stabiljegtabla.png");
    }

    @Override
    public void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.drawImage(this.image, 0, 0, size, size);

        if(model.getHoreteg() > 0)
            g.drawImage(ResourceProvider.getResource("ho.png"), 0, 0, size, size);

        for(int i = 0; i < mozgathatok.size(); ++i) {
            g.drawImage(mozgathatok.get(i).getDrawable(), i * size / mozgathatok.size(), 0, this.size / 2, this.size/4);
        }
    }
}
