package MVC.View.Game.Mozgathato.Karakterek;

import MVC.View.Game.Mezo.MezoView;
import MVC.View.Game.Mozgathato.MozgathatoView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EszkimoView extends MozgathatoView {
    public EszkimoView(MezoView mv) {
        super(mv);
        Image background = null;
        try {
            background = new Image(new FileInputStream("src/MVC/View/Resources/eskimo.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Image background = new Image("src/MVC/View/Resources/eszkimo.png");
        Background bg = new Background(new BackgroundImage(
                background,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        //this.setBackground(bg);
    }
}
