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
public class Sector {
    ArrayList<Wall> walls = new ArrayList<>();
    ArrayList<Integer> visibleSectors = new ArrayList<>();

    public Sector() {
    }
    
    public Sector(ArrayList<Wall> walls, ArrayList<Integer> visibleSectors) {
        this.walls = walls;
        this.visibleSectors = visibleSectors;
    }
    
     public Sector(ArrayList<Wall> walls) {
        this.walls = walls;
    }
}
