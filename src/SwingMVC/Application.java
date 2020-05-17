package SwingMVC;

import SwingMVC.View.GameBoard;

public class Application {

    private static GameBoard gameBoard;

    public static void main(String[] args){

        gameBoard = new GameBoard();
        gameBoard.start();
    }
}
