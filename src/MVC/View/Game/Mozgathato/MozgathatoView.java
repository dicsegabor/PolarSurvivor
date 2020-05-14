package MVC.View.Game.Mozgathato;

import MVC.View.Game.Mezo.MezoView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MozgathatoView extends Rectangle {
    private MezoView mezoView;

    public MozgathatoView(MezoView mv) {
        super(100, 200, Color.CADETBLUE);
        this.mezoView = mv;
    }
    public void lep(MezoView mv) {
        mezoView.kiad(this);
        mv.befogad(this);
    }
}
