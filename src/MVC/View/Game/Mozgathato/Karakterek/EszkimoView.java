package MVC.View.Game.Mozgathato.Karakterek;

import MVC.View.Game.Mozgathato.MozgathatoView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class EszkimoView extends MozgathatoView {
    public EszkimoView() {
        Image background = new Image("src/MVC/View/Resources/eszkimo.png");
        Background bg = new Background(new BackgroundImage(
                background,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        this.setBackground(bg);
    }
}
