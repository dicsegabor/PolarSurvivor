package MVC.View.Game;

import MVC.View.Game.Mezo.MezoView;
import MVC.View.Game.Mezo.MezoTipusok.JegtablaView;
import MVC.View.Game.Mozgathato.Karakterek.EszkimoView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameView extends FlowPane {
    private ArrayList<MezoView> mezok;

    public GameView(double width, double height) {
        this.setPrefSize(width, height);

        mezok = new ArrayList<MezoView>();
        mezok.add(new JegtablaView());
        JegtablaView jt = new JegtablaView();
        jt.getChildren().add(new EszkimoView());
        mezok.add(jt);
        mezok.add(new JegtablaView());
        this.getChildren().addAll(mezok);
    }
    public ArrayList<MezoView> getMezok() { return mezok; }
}
