package tictactoegame;

import tictactoegame.ai.aiinitialization.AIInitializator;
import tictactoegame.gui.MainMenu;

public class TicTacToeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize the ai
        new AIInitializator();
        
        //Open the game interface
        new MainMenu();
    }
}
