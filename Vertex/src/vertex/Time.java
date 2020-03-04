/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

/**
 *
 * @author child
 */
public class Time {
    static private long last_time = System.currentTimeMillis();
    static float deltaTime = 0;
    static int frameRate = 0;
    
    static void updateDeltaTime()
    {
        System.err.println("FrameRate : " + frameRate);
        long time = System.currentTimeMillis();
        deltaTime = ((time - last_time) / 1000);
        frameRate = (int) (1000 / deltaTime);
        last_time = time;
    }
}
