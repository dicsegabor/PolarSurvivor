package Graphics.View;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * View, Controller
 */
public class GameViewManager {

    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    public GameViewManager(int height, int width){

        initializeStage(height, width);
    }

    private void initializeStage(int height, int width) {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, width * 50 + 50, height * 50 + 50 );
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }
}
