package MVC.View.Menu;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.Collections;
import java.util.List;

public class MenuView extends GridPane {
    private MenuButton play;

    public MenuView(double w, double h) {
        this.setPrefSize(w, h);
        this.setAlignment(Pos.CENTER);
        play = new MenuButton("Play", 50, 20);
        MenuButton exit = new MenuButton("Exit", 50, 20);
        exit.setOnAction(e -> System.exit(0));
        this.add(play, 0, 0);
        this.add(exit, 0, 1);
    }
    public MenuButton getPlayButton() { return play; }
}
