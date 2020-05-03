package MVC.View.Game.Mezo.MezoTipusok;

import MVC.View.Game.Mezo.MezoView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class JegtablaView extends MezoView {
    public JegtablaView() {

        Image background = null;
        try {
            background = new Image(new FileInputStream("src/MVC/View/Resources/ice.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Background bg = new Background(new BackgroundImage(
                background,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        this.mezo.setBackground(bg);
        this.getChildren().add(mezo);
        this.menu = new ContextMenu();
    }

    public void showOptionsMenu(double x, double y, ArrayList<MenuItem> items) {
        menu.hide();
        menu.getItems().clear();
        menu.getItems().addAll(items);
        menu.show(mezo, x, y);
    }
}
