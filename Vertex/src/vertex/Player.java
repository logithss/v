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
public class Player extends Object{
    float speed;
    float angle;
    float fov;

    Player() {
    }
    
    public Player(float x, float y) {
        this.position = new Point(x, y);
        this.fov = 0;
        this.speed = 5;
        this.fov = 90;
    }

    public Player(float x, float y, float angle) {
        this.angle = angle;
        this.position = new Point(x, y);
        this.speed = 5;
        this.fov = 90;
    }
    
    
    
    
}
