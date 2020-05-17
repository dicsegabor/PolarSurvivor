package MVC.Controller;

import MVC.CanvasView.GameViewCanvas;
import MVC.Model.GameModel;
import MVC.View.Game.GameView;
import MVC.View.Menu.MenuView;
import javafx.scene.layout.Pane;

public class Controller {
    private MenuView menu;
    private GameViewCanvas game;
    private Pane window;
    private GameControllerCanvas gc;

    public Controller(Pane window) {
        this.window = window;
        menu = new MenuView(window.getPrefWidth(), window.getPrefHeight());
        window.getChildren().add(menu);
        menu.getPlayButton().setOnAction(e -> startNewGame());
    }

    private void startNewGame() {
        window.getChildren().clear();
        game = new GameViewCanvas(window.getPrefWidth(), window.getPrefHeight());
        gc = new GameControllerCanvas(game);
        window.getChildren().add(game);
    }
}
