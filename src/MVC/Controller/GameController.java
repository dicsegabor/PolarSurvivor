package MVC.Controller;

import MVC.Model.GameModel;
import MVC.View.Game.GameView;
import MVC.View.Game.Mezo.MezoView;
import Mezo.Mezo;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameView view) {
        model = new GameModel();
        this.view = view;
        int idx = 0;
        for(MezoView mv : view.getMezok()) {
            int i = idx;
            mv.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                mv.showOptionsMenu(e.getScreenX(), e.getScreenY(), options(i));
            });
            idx++;
        }
    }
    private ArrayList<MenuItem> options(int mezoIndex) {
        ArrayList<MenuItem> options = new ArrayList<>();
        Mezo jelenlegi = model.getCurrentKarakter().getMezo();
        Mezo kattintott = model.getMezok().get(mezoIndex);
        if(jelenlegi.szomszedE(kattintott)) {
            MenuItem lep = new MenuItem("Lep");
            lep.setOnAction(e -> model.getCurrentKarakter().lep(kattintott));
            options.add(lep);
        }
        return options;
    }
}
