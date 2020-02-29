/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

import java.awt.Color;



/**
 *
 * @author cstuser
 */
public class Renderer {
    float fogFallDistance;
    
    static int screenWidth = 480;
    static int screenHeight = 360;
    
    Color[][] c = new Color[screenWidth][screenHeight];
    
    static void render()
    {
        for (int x = 0; x < screenWidth; x++)
		{
			
			
			float fRayAngle = (Game.player.angle - Game.player.fov / 2.0f) + ((float)x / (float)screenWidth) * Game.player.fov;
			float correctionAngle = fRayAngle - Game.player.angle;
			float fEyeX = (float) Math.sin(fRayAngle); // Unit vector for ray in player space
			float fEyeY = (float) Math.cos(fRayAngle);
			float ix = 100 * fEyeX;
			float iy = 100 * fEyeY;
                        
                        

			

		}
    }
}
