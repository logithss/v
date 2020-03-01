/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

import java.awt.Color;
import java.util.Arrays;

/**
 *
 * @author child
 */
public class Strip {
    Point[] screenCoordinates = new Point[2];
    Color color;
    boolean render;
    
    Strip()
    {
        render = false;
    }
    
    Strip(Point p1, Point p2, Color color)
    {
        screenCoordinates[0] = p1;
        screenCoordinates[1] = p2;
        this.color = color;
        render = true;
    }
    
    Strip(float x, float y1, float y2, Color color)
    {
        screenCoordinates[0] = new Point(x, y1);
        screenCoordinates[1] = new Point(x, y2);
        this.color = color;
        render = true;
    }
    
    Strip(float x, float y1, float y2)
    {
        screenCoordinates[0] = new Point(x, y1);
        screenCoordinates[1] = new Point(x, y2);
        this.color = Color.BLACK;
        render = true;
    }
    
    void arrange()
    {
        Arrays.sort(screenCoordinates);
    }
    
    public String toString()
    {
        return screenCoordinates[0] + " to : " + screenCoordinates[1];
    }
}
