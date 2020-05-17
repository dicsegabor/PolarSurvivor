package Graphics.Application;

import Graphics.View.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class GraphicsProgram extends Application {

    @Override
    public void start(Stage primaryStage) {

        ViewManager manager = new ViewManager();
        try {
            primaryStage = manager.getMainStage();
            primaryStage.show();
        }
        catch (Exception e){ e.printStackTrace(); }
    }

    public static void main(String[] args){

        launch(args);
    }
}