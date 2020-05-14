package MVC.View.Game.Mezo.MezoTipusok;

import MVC.View.Game.Mezo.MezoView;
import Mezo.Mezo;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class JegtablaView extends MezoView {
    public JegtablaView(Mezo m) {
        super(m);
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

        this.mezoImage = new Image("file:src/MVC/View/Resources/ice.png");
    }

    @Override
    public void draw(Canvas canvas, int x, int y, double w, double h) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.drawImage(mezoImage, x, y, w, h);
    }

    public void showOptionsMenu(double x, double y, ArrayList<MenuItem> items) {
        menu.hide();
        menu.getItems().clear();
        menu.getItems().addAll(items);
        menu.show(mezo, x, y);
    }
}
