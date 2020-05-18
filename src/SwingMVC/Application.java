package SwingMVC;

import SwingMVC.Controller.Controller;
import SwingMVC.View.GameBoard;

public class Application {

    private static GameBoard gameBoard;

    public static void main(String[] args){

        gameBoard = new GameBoard();
        Controller.getInstance().addGameBoard(gameBoard);
        gameBoard.start();
    }
}
