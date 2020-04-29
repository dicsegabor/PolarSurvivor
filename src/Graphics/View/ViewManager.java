package Graphics.View;

import Graphics.Model.PolarButton;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {

    final private int HEIGHT = 600;
    final private int WIDTH = 800;
    private List<PolarButton> menuButtons;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    final private static int MENU_BUTTONS_START_X = 300;
    final private static int MENU_BUTTONS_START_Y = 175;

    public ViewManager(){

        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createBackground();
        createButtons();
        createLogo();
    }

    public Stage getMainStage() {

        return mainStage;
    }

    private void addMenuButton(PolarButton button){

        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + (menuButtons.size() * 85));
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButtons(){

        createStartButton();
        createScoresButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void createStartButton(){
        PolarButton startButton = new PolarButton("START");
        addMenuButton(startButton);
    }

    private void createScoresButton(){
        PolarButton scoresButton = new PolarButton("SCORES");
        addMenuButton(scoresButton);
    }

    private void createHelpButton(){
        PolarButton helpButton = new PolarButton("HELP");
        addMenuButton(helpButton);
    }

    private void createCreditsButton(){
        PolarButton creditsButton = new PolarButton("CREDITS");
        addMenuButton(creditsButton);
    }

    private void createExitButton(){
        PolarButton exitButton = new PolarButton("EXIT");
        addMenuButton(exitButton);

        exitButton.setOnMousePressed(mouseEvent -> Platform.exit());
    }

    private void createBackground(){

        Image backgroundImage = new Image("Graphics/View/Resources/IceBackground.jpg", 256, 256, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo(){

        ImageView logo = new ImageView("Graphics/View/Resources/Logo.png");
        logo.setLayoutX(170);
        logo.setLayoutY(50);

        logo.setOnMouseEntered(mouseEvent -> logo.setEffect(new DropShadow()));

        logo.setOnMouseExited(mouseEvent -> logo.setEffect(null));

        mainPane.getChildren().add(logo);
    }
}
