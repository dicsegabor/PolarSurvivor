package MVC.Controller;

import MVC.Model.GameModel;
import MVC.View.Game.GameView;
import MVC.View.Game.Mezo.MezoTipusok.JegtablaView;
import MVC.View.Game.Mezo.MezoView;
import MVC.View.Game.Mozgathato.Karakterek.EszkimoView;
import MVC.View.Game.Mozgathato.MozgathatoView;
import Mezo.Mezo;
import Mozgathato.Karakter;
import Proto.Commander.Exceptions.WrongArgumentException;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class GameController {
    private GameModel model;
    private GameView view;
    private Karakter aktualisKarakter;
    private MozgathatoView aktualisKarakterView;

    public GameController(GameView view) {
        model = new GameModel();
        aktualisKarakter = model.getCurrentKarakter();
        this.view = view;
        init();
        aktualisKarakterView = view.getKarakterek().get(0);
        for(MezoView mv : view.getMezok()) {
            mv.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                mv.showOptionsMenu(e.getScreenX(), e.getScreenY(), options(mv));
            });
        }
    }

    private void init() {
        view.setMapSize(3, 3);
        model.getMezok().forEach(m -> {
            JegtablaView jv = new JegtablaView(m);
            m.getKarakterek().forEach(k -> {
                MozgathatoView kar = new EszkimoView(jv);
                view.addKarakter(kar);
                jv.befogad(kar);
            });
            view.addMezo(jv);
        });
    }

    private ArrayList<MenuItem> options(MezoView mv) {
        ArrayList<MenuItem> options = new ArrayList<>();
        Mezo jelenlegi = model.getCurrentKarakter().getMezo();
        if(jelenlegi.szomszedE(mv.getModelMezo())) {
            MenuItem lep = new MenuItem("Lep");
            lep.setOnAction(e -> {
                aktualisKarakter.lep(mv.getModelMezo());
                aktualisKarakterView.lep(mv);
            });
            options.add(lep);
        }
        return options;
    }
}
