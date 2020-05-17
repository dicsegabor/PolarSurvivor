package MVC.CanvasView;

import javafx.scene.layout.Pane;

public class MezoView extends Pane {

    public MezoView(int x, int y, int size) {
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setPrefSize(size, size);
    }
}
