package MVC.View;

import Graphics.View.ViewManager;
import MVC.Controller.Controller;
import MVC.Controller.GameController;
import MVC.View.Menu.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game_Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane window = new Pane();
        window.setPrefSize(1280, 720);

        Controller controller = new Controller(window);
        Scene scene = new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){

        launch(args);
    }
}
