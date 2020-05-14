package MVC.View.Game;

import MVC.View.Game.Mezo.MezoView;
import MVC.View.Game.Mezo.MezoTipusok.JegtablaView;
import MVC.View.Game.Mozgathato.Karakterek.EszkimoView;
import MVC.View.Game.Mozgathato.MozgathatoView;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GameView extends GridPane {
    private ArrayList<MezoView> mezok;
    private ArrayList<MozgathatoView> mozgathatok;
    private ArrayList<MozgathatoView> karakterek;
    private int mapWidth, mapHeight;

    public GameView(double width, double height) {
        this.setPrefSize(width, height);
        this.setAlignment(Pos.CENTER);

        mezok = new ArrayList<MezoView>();
        mozgathatok = new ArrayList<MozgathatoView>();
        karakterek = new ArrayList<MozgathatoView>();
    }

    public void setMapSize(int x, int y) { mapWidth = x; mapHeight = y; }

    public ArrayList<MezoView> getMezok() { return mezok; }

    public void addMezo(MezoView mv) {
        this.add(mv,mezok.size() % mapHeight, mezok.size()/mapWidth);
        mezok.add(mv);
    }

    public ArrayList<MozgathatoView> getKarakterek() { return karakterek; }

    public void addKarakter(MozgathatoView k) {
        karakterek.add(k);
        mozgathatok.add(k);
    }

    public void addJegesmedve(MozgathatoView j) {
        mozgathatok.add(j);
    }
}
