package MVC.CanvasView.Mezo;

import MVC.CanvasView.Drawables.StabilJegtablaGroup;
import Mezo.StabilJegtabla;

public class StabilJegtablaView extends MezoView {
    public StabilJegtablaView(int size, StabilJegtablaGroup g) {
        super(size);
        this.mezoGroup = g;
        this.getChildren().add(mezoGroup.getCanvas());
    }
}
