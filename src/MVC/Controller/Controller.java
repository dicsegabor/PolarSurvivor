package MVC.Controller;

import MVC.Model.GameModel;
import MVC.View.Game.GameView;
import MVC.View.Menu.MenuView;
import javafx.scene.layout.Pane;

public class Controller {
    private MenuView menu;
    private GameView game;
    private GameModel model;
    private Pane window;

    public Controller(Pane window) {
        model = new GameModel();
        this.window = window;
        menu = new MenuView(window.getPrefWidth(), window.getPrefHeight());
        window.getChildren().add(menu);
        menu.getPlayButton().setOnAction(e -> startNewGame());
    }
    private void startNewGame() {
        window.getChildren().clear();
        window.getChildren().add(new GameView(window.getPrefWidth(), window.getPrefHeight()));
    }
}
