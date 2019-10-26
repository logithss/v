package tictactoegame;

import tictactoegame.ai.AIChoices;

public class GameSystem {
    
    public static boolean tie = false;
    public static boolean turn = true;
    public static boolean endGame = false;
    public static boolean isAgainstComputer = false;
    public static boolean computerTurn = true;
    public static String gamePattern = "";
    private static byte victory = 0;
    private static byte score = 0;
    
    public static int[] grid = {5, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[][] victoryCombinations = {
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
        {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
        {1, 5, 9}, {3, 5, 7} 
    };

    public GameSystem() {
    }
    
    ////////////////////////////////////////////////////////////////
    
    //Method for clearing the grid
    public static void flushGrid(){
        turn = true;
        tie = false;
        endGame = false;
        victory = 0;
        score = 0;
        gamePattern = "";
        for(int i=1; i<10; i++){
            grid[i] = 0;
        }
    }
    
    //Method to try if victory
    public static byte isVictory(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 3; j++){
                //Check the state of the coordinate
                switch(grid[victoryCombinations[i][j]]){
                    case 1:
                        score++;
                        break;
                    case -1:
                        score--;
                        break;
                }
            }
                        
            if(score == 3){
                victory = 1;
                break;
            }        
            else if(score == -3){
                victory = 2;
                break;
            }
            
            score = 0;
        }
        
        return victory;
    }
    
    public static void victorySettings(){
        switch (victory) {
            case 1:
                endGame = true;
                break;
            case 2:
                endGame = true;
                break;
            case 0:
                for(int t=1; t<=9; t++){
                    if(grid[t] != 0){
                        tie = true;
                    }
                    else{
                        tie = false;
                        break;
                    }
                }   
                if(tie){
                    endGame = true;
                }   
                break;
            default:
                break;
        }
    }
    
    public static void aiPlay(){
        AIChoices ai = new AIChoices();
        
        if(isAgainstComputer && turn == computerTurn)
            ai.play();
    }
}
