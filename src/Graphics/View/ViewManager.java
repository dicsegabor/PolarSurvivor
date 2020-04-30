package Graphics.View;

import Graphics.Model.PolarButton;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {

    private List<PolarButton> menuButtons;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    /*private static double ORIGINAL_HEIGHT = 1080;
    private static double ORIGINAL_WIDTH = 1920;
    public static double HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
    public static double WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
    public final static double RATIO = Math.min((ORIGINAL_HEIGHT / HEIGHT), (ORIGINAL_WIDTH / WIDTH));
    public final static Point2D CENTER = new Point2D(WIDTH / 2, HEIGHT / 2);*/

    public ViewManager(){

        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, 800, 600);
        mainStage = new Stage();
        mainStage.setResizable(false);
        mainStage.setScene(mainScene);
        mainStage.getIcons().add(new Image("Graphics/View/Resources/Menu/PolarIcon.png"));
        createBackground();
        createButtons();
        createLogo();
    }

    public Stage getMainStage() {

        return mainStage;
    }

    private void addMenuButton(PolarButton button){

        button.setLayoutX(100);
        button.setLayoutY(175 + menuButtons.size() * 85);
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

        exitButton.setOnMousePressed(mouseEvent -> mainStage.close());
    }

    private void createBackground(){

        Image backgroundImage = new Image("Graphics/View/Resources/Menu/IceBackground.jpg", 200, 200, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo(){

        ImageView logo = new ImageView("Graphics/View/Resources/Menu/Logo.png");
        logo.setLayoutX(170);
        logo.setLayoutY(50);

        logo.setOnMouseEntered(mouseEvent -> logo.setEffect(new DropShadow()));

        logo.setOnMouseExited(mouseEvent -> logo.setEffect(null));

        mainPane.getChildren().add(logo);
    }
}
