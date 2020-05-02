package MVC.View.Game;

import MVC.View.Game.Mezo.MezoView;
import MVC.View.Game.Mezo.MezoTipusok.JegtablaView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameView extends Pane {
    private ArrayList<MezoView> mezok;

    public GameView(double width, double height) {
        this.setPrefSize(width, height);

        mezok = new ArrayList<MezoView>();
        mezok.add(new JegtablaView());
        this.getChildren().addAll(mezok);
    }
}
