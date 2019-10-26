package tictactoegame.ai.aiinitialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import tictactoegame.GameSystem;

//Review this class
public class AIInitializator extends GameSystem{
    public static String[] xDB = 
            Arrays.copyOf(dbInit("xDB"), dbInit("xDB").length) ;
    public static String[] oDB = 
            Arrays.copyOf(dbInit("oDB"), dbInit("oDB").length) ;
    public static String[] tDB = 
            Arrays.copyOf(dbInit("tDB"), dbInit("tDB").length) ;
    
    public AIInitializator() {
        
    }
    
    private static String[] dbInit(String dbFileName){
        File dbFile = new File("src/tictactoegame/ai/db/" + dbFileName + ".db");
        int i = 0;
        String[] tempDB = new String[fileLength(dbFile)];
        
        try {
            Scanner scan = new Scanner(dbFile);
            
            while (scan.hasNext()) {
                String pattern = scan.nextLine();
                
                tempDB[i] = pattern;
                i++;
            }
            
            return tempDB;
        } catch (FileNotFoundException ex) {
            return new String[0];
        }
    }
    
    private static int fileLength(File f){
        int l = 0;
        
        try {
            Scanner sc = new Scanner(f);
        
            while (sc.hasNext()) {
                l++;
                sc.nextLine();
            }
        
            return l;
        } catch (FileNotFoundException ex) {
            return l;
        }
    }
}