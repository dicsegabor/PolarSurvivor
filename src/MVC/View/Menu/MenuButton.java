package MVC.View.Menu;

import javafx.scene.control.Button;

public class MenuButton extends Button {

    private String text;
    private int width, height;

    public MenuButton(String text, int width, int height) {

        super(text);
        this.text = text;
        this.setPrefSize(width, height);
    }
}
