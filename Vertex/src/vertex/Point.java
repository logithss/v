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
public class Point implements Comparable<Point>{
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
    
    
    float getDistanceTo(Point p)
    {
        float a = (float) (Math.pow((this.y - p.y),2) + Math.pow((this.x - p.x),2));
        return (float) Math.sqrt(a);
    }
    
    static float getDistance(Point p1, Point p2)
    {
        float a = (float) (Math.pow((p2.y - p1.y),2) + Math.pow((p2.x - p1.x),2));
        return (float) Math.sqrt(a);
    }
    
    public String toString()
    {
        if(exist)
            return "x : " + x + " y : " + y;
        else
            return "dosent exist";
    }

    @Override
    public int compareTo(Point p) {
        if(x == p.x) {
            if(y > p.y) return 1;
            else if(y == p.y) return 0;
            else return -1;
        }
        else if (y == p.y)
        {
            if(x > p.x) return 1;
            else if(x == p.x) return 0;
            else return -1;
        }
        else return 0;
    }
    
    
    
}
