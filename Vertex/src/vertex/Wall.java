/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

/**
 *
 * @author cstuser
 */
public class Wall extends Object implements Comparable<Wall> {
    Line line;
    float z;
    float height;
    String texture;
    Boolean isCollider;
    Boolean isVisible;

    public Wall(Line line, float z, float height, String texture, Boolean isCollider, Boolean isVisible) {
        this.line = line;
        this.z = z;
        this.height = height;
        this.texture = texture;
        this.isCollider = isCollider;
        this.isVisible = isVisible;
    }

    public Wall(Line line, float z, float height, String texture) {
        this.line = line;
        this.z = z;
        this.height = height;
        this.texture = texture;
    }
    
    public Wall(Line line, int id) {
        this.line = line;
        this.id = id;
    }

    
    public int compareTo(Wall w) {
         Point playerPos = Game.player.position;
         Line l1 = new Line(playerPos, this.line.p1);
         Line l2 = new Line(playerPos, this.line.p2);
         System.out.println(id +" : "+w.id);
         
         if(w.line.isCrossing(l1).exist == true) {System.out.println("col1");return 1;}
         else if(w.line.isCrossing(l2).exist == true) {System.out.println("col2");return 1;}
         else {System.out.println("col3");return 0;}
    }
    
    public String toString()
    {
        return Integer.toString(this.id);
    }
    
    
}
