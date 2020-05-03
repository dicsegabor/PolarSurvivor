package MVC.Controller;

import MVC.Model.GameModel;
import MVC.View.Game.GameView;
import MVC.View.Menu.MenuView;
import javafx.scene.layout.Pane;

public class Controller {
    private MenuView menu;
    private GameView game;
    private Pane window;
    private GameController gc;

    public Controller(Pane window) {
        this.window = window;
        menu = new MenuView(window.getPrefWidth(), window.getPrefHeight());
        window.getChildren().add(menu);
        menu.getPlayButton().setOnAction(e -> startNewGame());
    }

    private void startNewGame() {
        window.getChildren().clear();
        game = new GameView(window.getPrefWidth(), window.getPrefHeight());
        gc = new GameController(game);
        window.getChildren().add(game);
    }
}
