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
public class Point {
    float x, y;
    boolean exist;

    public Point() {
        this.exist = true;
    }
    
    public Point(boolean exist) {
        this.exist = exist;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.exist = true;
    }
    
    static double getDistance(Point p1, Point p2)
    {
        float a = (float) (Math.pow((p2.y - p1.y),2) + Math.pow((p2.x - p1.x),2));
        return Math.sqrt(a);
    }
    
    public String toString()
    {
        if(exist)
            return "x : " + x + " y : " + y;
        else
            return "dosent exist";
    }
    
}
