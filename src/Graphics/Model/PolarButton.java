package Graphics.Model;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PolarButton extends Button {

    private final String FONT_PATH = "src/Graphics/Model/Resources/PolarVortex-raAA.ttf";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Graphics/Model/Resources/PressedIcyButton.png');";
    private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Graphics/Model/Resources/FreeIcyButton.png');";

    public PolarButton(String text){

        setText(text);
        setButtonFont();
        setPrefHeight(50);
        setPrefWidth(200);
        setStyle(BUTTON_FREE_STYLE);
        initializeButtonListeners();
    }

    private void setButtonFont(){

        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException e){
            setFont(Font.font("Arial", 23));
        }
    }

    private void setButtonPressedStyle(){

        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(50);
    }

    private void setButtonReleasedStyle(){

        setStyle(BUTTON_FREE_STYLE);
        setPrefHeight(50);
    }

    private void initializeButtonListeners(){

        setOnMousePressed(mouseEvent -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY))
                setButtonPressedStyle();
        });

        setOnMouseReleased(mouseEvent -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY))
                setButtonReleasedStyle();
        });

        setOnMouseEntered(mouseEvent -> setEffect(new DropShadow()));

        setOnMouseExited(mouseEvent -> setEffect(null));
    }
}
