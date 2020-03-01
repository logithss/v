/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javafx.scene.shape.TriangleMesh;
import javax.swing.JFrame;


/**
 *
 * @author cstuser
 */


public class Main {

    //static World game;
    public static void main(String[] args){
        // TODO code application logic here
        Line l1 = new Line(new Point(-2, 2), new Point(2, 2));
        Line l2 = new Line(new Point(-1, 3), new Point(1, 3));
        Line l3 = new Line(new Point(-0.5f, 2.5f), new Point(0.5f, 2.5f));
        Line l4 = new Line(new Point(2, 0.1f), new Point(-2f, 0.1f));
        ArrayList<Wall> walls = new ArrayList<Wall>();
        
        
        walls.add(new Wall(l3, 2));
        walls.add(new Wall(l1, 0));
        walls.add(new Wall(l2, 1));
        walls.add(new Wall(l4, 3));
        
        Sector s = new Sector(walls);
        
        Game.sectors.add(s);
        Game.gameLoop();
        
        
        JFrame window = new JFrame("Vertex Engine");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(480, 360);
        window.setResizable(true);
        //window.setUndecorated(true);
        window.setVisible(true);
        
        RenderPanel panel = new RenderPanel();
        Game.panel = panel;
        window.add(panel);
        window.setVisible(true);
        
        /*Scanner scan = new Scanner(System.in);
        
        float x = 2.0f;
        
        x = scan.nextFloat();*/
        
        
        
        
         //panel.repaint();
        
        while(true){
          //Game.gameLoop();
          panel.repaint();
        }
        
        
    }
    
}


