package tictactoegame.ai;

import java.util.Arrays;
import tictactoegame.GameSystem;
import tictactoegame.ai.aiinitialization.AIInitializator;
import tictactoegame.gui.GUI;

public class AIChoices extends AIInitializator{
    private final int gameLength = gamePattern.length();
    private int[][] playScore = new int[2][9];
    //private String[] winningDB;
    //private String[] losingDB;
    
    public AIChoices(){
        this.fillPlayScores();
    }
    
    private void fillPlayScores(){
        if(computerTurn){
            testPlays(xDB, oDB);
        }
        else{
            testPlays(oDB, xDB);
        }
    }
    
    private void testPlays(String [] winningDB, String [] losingDB){        
        for (String winString : winningDB) {
            if(winString.startsWith(gamePattern) 
                    && winString.length()>gameLength)
                this.configPlayScore(winString.charAt(gameLength), 0);
        }
        for (String loseString : losingDB) {
            if(loseString.startsWith(gamePattern) 
                    && loseString.length()>gameLength)
                this.configPlayScore(loseString.charAt(gameLength), 1);
        }
    }
    
    //Win = 0 ; Lose = 1
    public void configPlayScore(char button, int winOrLose){
        switch(button){
            case '1':
                playScore[winOrLose][0]++;
                break;
            case '2':
                playScore[winOrLose][1]++;
                break;
            case '3':
                playScore[winOrLose][2]++;
                break;
            case '4':
                playScore[winOrLose][3]++;
                break;
            case '5':
                playScore[winOrLose][4]++;
                break;
            case '6':
                playScore[winOrLose][5]++;
                break;
            case '7':
                playScore[winOrLose][6]++;
                break;
            case '8':
                playScore[winOrLose][7]++;
                break;
            case '9':
                playScore[winOrLose][8]++;
                break;
        } 
    }
    
    private int getBestPlay(){
        float lastBestPlay = 0;
        int bestPlay = 0;
        int square = 1;
        float[] ratios = Arrays.copyOf(this.ratios(), this.ratios().length);
        
        for (float ratio : ratios) {
            if(ratio > lastBestPlay){
                if(GameSystem.grid[square] == 0){
                    lastBestPlay = ratio;
                    bestPlay = square;
                }
            }
            
            square++;
        }
        
        int whereForWin = this.takeWin();
        int whereToBlock = this.blockDanger();
        
        if(this.takeWin() != 0)
            return whereForWin;
        else if(this.blockDanger() != 0)
            return whereToBlock;
        else if(bestPlay == 0)
            return this.playForTie();
        
        return bestPlay;
    }
    
    private float[] ratios(){
        float[] ratios = new float[9];
        int i = 0;
        
        for (float ratio : ratios) {
            float wins = playScore[0][i];
            float loses = playScore[1][i];
            ratios[i] = wins/loses;
            i++;
        }
        
        return ratios;
    }
    
    private int takeWin(){        
        if(computerTurn){
            for (String win : xDB) {
                if(win.startsWith(gamePattern) && win.length() == (gameLength+1))
                    return Integer.parseInt("" + win.charAt(gameLength));
            }
        }
        else{
            for (String win : oDB) {
                if(win.startsWith(gamePattern) && win.length() == (gameLength+1))
                    return Integer.parseInt("" + win.charAt(gameLength));
            }
        }
        
        return 0;
    }
    
    private int blockDanger(){        
        if(computerTurn){
            for (String lose : oDB) {
                if(lose.startsWith(gamePattern) && lose.length() == (gameLength+1))
                    return Integer.parseInt("" + lose.charAt(gameLength));
            }
        }
        else{
            for (String lose : xDB) {
                if(lose.startsWith(gamePattern) && lose.length() == (gameLength+2))
                    return Integer.parseInt("" + lose.charAt(gameLength+1));
            }
        }
        
        return 0;
    }
    
    private int playForTie(){
        int forTie = 0;
        for (String t : tDB) {
            if(t.startsWith(gamePattern)){
                forTie = Integer.parseInt("" + t.charAt(gameLength));
            }
        }
        
        return forTie;
    }
    
    public void play(){
        int play = this.getBestPlay();
        GUI.buttons[play].doClick();
    }
}
