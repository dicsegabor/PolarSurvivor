package MVC.View.Game.Mezo.MezoTipusok;

import MVC.View.Game.Mezo.MezoView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JegtablaView extends MezoView {
    public JegtablaView() {
        Image background = new Image("src/MVC/View/Resources/ice.png");
        Background bg = new Background(new BackgroundImage(
                background,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        this.mezo.setBackground(bg);
        this.getChildren().add(mezo);
    }
}
