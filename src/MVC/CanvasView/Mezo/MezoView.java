package MVC.CanvasView.Mezo;

import MVC.CanvasView.Drawables.MezoGroup;
import Mezo.Mezo;
import javafx.scene.layout.Pane;

public abstract class MezoView extends Pane {
    protected MezoGroup mezoGroup;

    public MezoView(int size) {
        this.setMinSize(size, size);
    }

    public void draw() { mezoGroup.draw(); }
}
