/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

import java.util.ArrayList;

/**
 *
 * @author cstuser
 */
public class Game {
    static RenderPanel panel;
    static Player player = new Player(0, 0);
    
    static int word = 123;
    static int speed = 1000;
    
    static ArrayList<Sector> sectors;
    static int currentSector;
    
    
    static void gameLoop()
    {
        
          Game.word ++;
         
    }
    
}


