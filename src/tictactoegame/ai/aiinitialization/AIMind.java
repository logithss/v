package tictactoegame.ai.aiinitialization;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import tictactoegame.GameSystem;

//Class to generate the database of the Game
public class AIMind {
    
    //Initializing values
    private boolean virtualTurn = true;
    StringPermutation sp = new StringPermutation("123456789");
    private String[] allBoardPossibilities = 
            Arrays.copyOf(this.sp.getAllStringPermutations(), 
                    this.sp.getAllStringPermutations().length);
    
    public AIMind() {
        
    }

////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    public String[] getAllBoardPossibilities() {
        return this.allBoardPossibilities;
    }

    public void setAllBoardPossibilities(String[] allBoardPossibilities) {
        String[] transArr = allBoardPossibilities;
        
        this.allBoardPossibilities = Arrays.copyOf(transArr, transArr.length);
    }

    public boolean isVirtualTurn() {
        return this.virtualTurn;
    }

    public void setVirtualTurn(boolean virtualTurn) {
        this.virtualTurn = virtualTurn;
    }
    
////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    //Method to virtually play a combination of the board
    private String playVirtualGame(String game){
        char[] plays = game.toCharArray();
        String trueGame = "";
        
        for (char play : plays) {
            trueGame += play;
            int square = Integer.parseInt("" + play);
            
            if(virtualTurn){
                GameSystem.grid[square] = 1;
                virtualTurn = false;
            } 
            else if(!virtualTurn){
                GameSystem.grid[square] = -1;
                virtualTurn = true;
            }
            
            String resV = determineV(trueGame); //Method below
            
            if(!resV.isEmpty()){                
                this.virtualTurn = true;
                GameSystem.flushGrid();
                return resV;
            }
        }
        
        return trueGame;
    }
    
    //Method to determine the outcome of the virtual game
    private String determineV(String game){
        byte v = GameSystem.isVictory();
        GameSystem.victorySettings();
        
        //Depending on the outcome, add at 
        //the beginning of the string if its X, Y, or TIE
        if(v == 1){
            return "x" + game;
        }
        else if(v == 2){
            return "o" + game;
        }
        else if(v == 0 && GameSystem.tie){
            return "t" + game;
        }
        else
            return "";
    }
    
    //Method to filter the data entering an array, so there is no double
    private boolean filterData(String[] tempArray, String toAdd){
        boolean isGood = false;
        for (String string : tempArray) {
            try{
                if(string.equals(toAdd)){
                    return false;
                }
                else{
                    isGood = true;
                }
            } catch(NullPointerException npe){
                return true;
            }
        }
        
        return isGood;
    }
    
    //First big method, sort allBoardPossibilities array 
    //to create all possible game patterns with the outcome
    public String[] sortTTT(){
        String[] tempArray = new String[this.allBoardPossibilities.length];
        String tempData = "";
        int index = 0;

        for (String aBoardPossibility : allBoardPossibilities) {
            tempData = this.playVirtualGame(aBoardPossibility);
            boolean proceed = filterData(tempArray, tempData);
            
            if(proceed){
                tempArray[index] = tempData;
                index++;
            } 
        }
        
        return tempArray;
    }
    
    //Second big method of the class: Returns an array without null expressions.
    public String[] finalFilter(String[] tempArray){
        int arrayLength = 0;
        
        for (String string : tempArray) {
            if(string == null)
                break;
            else
                arrayLength++;
        }
        
        String[] newArray = new String[arrayLength];
        
        System.arraycopy(tempArray, 0, newArray, 0, newArray.length);
        
        return newArray;
    }
    
    //Class that will create the database files
    public boolean saveDB(String[] dataBase) {
        File db = new File("src/tictactoe/ai/db");
        File xFile = new File("src/tictactoegame/ai/db/xDB.db");
        File oFile = new File("src/tictactoegame/ai/db/oDB.db");
        File tFile = new File("src/tictactoegame/ai/db/tDB.db");
        
        
        try {
            if(!db.exists()){
                db.mkdirs();
            }
            if (!xFile.exists()) {
                xFile.createNewFile();
            }
            if (!oFile.exists()) {
                oFile.createNewFile();
            }
            if (!tFile.exists()) {
                tFile.createNewFile();
            }
        
            PrintWriter tWriter = new PrintWriter(tFile);
            PrintWriter xWriter = new PrintWriter(xFile);
            PrintWriter oWriter = new PrintWriter(oFile);
        
            for (String string : dataBase) {
                if (string.contains("x")) {
                    xWriter.println(string.substring(1, string.length()));
                }
                else if (string.contains("o")) {
                    oWriter.println(string.substring(1, string.length()));
                }
                else if (string.contains("t")) {
                    tWriter.println(string.substring(1, string.length()));
                }
            }
        
            tWriter.close();
            xWriter.close();
            oWriter.close();
            
            return true;
            } 
        catch (IOException e) {
            return false;
        }
    }
}