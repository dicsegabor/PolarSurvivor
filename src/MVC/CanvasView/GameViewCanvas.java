package MVC.CanvasView;

import MVC.CanvasView.Drawables.MezoGroup;
import MVC.CanvasView.Drawables.Mozgathato.Eszkimo;
import MVC.CanvasView.Drawables.StabilJegtablaGroup;
import MVC.CanvasView.Mezo.MezoView;
import MVC.CanvasView.Mezo.StabilJegtablaView;
import MVC.Model.GameModel;
import Mezo.Mezo;
import Mezo.StabilJegtabla;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GameViewCanvas extends GridPane {
    private ArrayList<MezoView> mezok;
    private double width, height;

    public GameViewCanvas(double w, double h) {
        this.setMinSize(w, h);
        width = w; height = h;
        mezok = new ArrayList<>();
    }

    public void drawAll() {
        mezok.forEach(m -> m.draw());
    }

    public void init(GameModel model) {
        mezok.clear();
        int mapWidth = 5, mapHeight = 3;
        int size = model.getMezok().size();
        for(int i = 0; i < model.getMezok().size(); ++i) {
            Mezo m = model.getMezok().get(i);
            MezoGroup mg = new StabilJegtablaGroup((int)this.height / mapHeight, m);
            m.getKarakterek().forEach(k -> mg.getMozgathatok().add(new Eszkimo()));
            MezoView mv = new StabilJegtablaView((int)this.height/mapHeight, (StabilJegtablaGroup) mg);
            this.add(mv, i % mapHeight, i / mapWidth);
            mezok.add(mv);
        }
    }
}
