package MVC.Controller;

import MVC.CanvasView.GameViewCanvas;
import MVC.Model.GameModel;
import javafx.scene.layout.Pane;

public class GameControllerCanvas {
    private GameModel model;
    private GameViewCanvas view;

    public GameControllerCanvas(GameViewCanvas view) {
        model = new GameModel();
        this.view = view;
        init();
    }

    void init() {
        view.init(model);
        view.drawAll();
    }
}
