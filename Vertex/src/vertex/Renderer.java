/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author cstuser
 */
public class Renderer {
    static float fogFallDistance;
    
    static int screenWidth = 480;
    static int screenHeight = 360;
    
    static Color[][] c = new Color[screenWidth][screenHeight];
    
    //static ArrayList<Strip>[] strips = new ArrayList[screenWidth];
    static StripCollection[] strips;
    
    static void renderWorld()
    {
        strips = new StripCollection[screenWidth];
        for (int x = 0; x < screenWidth; x++)
		{
                    System.out.println("> " + x);
			
			
			float fRayAngle = (Game.player.angle - Game.player.fov / 2.0f) + ((float)x / (float)screenWidth) * Game.player.fov;
			float correctionAngle = fRayAngle - Game.player.angle;
			float fEyeX = (float) Math.sin(fRayAngle); // Unit vector for ray in player space
			float fEyeY = (float) Math.cos(fRayAngle);
			float ix = 100 * fEyeX;
			float iy = 100 * fEyeY;
                        
                        Line sightLine = new Line(Game.player.position, new Point(ix, iy));
                        
                        for(Sector s : Game.sectors)
                        {
                            for(Wall w : s.walls)
                            {
                             System.out.println(w);   
                            }
                            
                            for(Wall w : s.walls)
                            {
                                Point crossPoint = w.isCrossing(sightLine);
                                if(crossPoint.exist)
                                {
                                    float hitDistance = crossPoint.getDistanceTo(Game.player.position);
                                    
                                    if(hitDistance <= fogFallDistance)
                                    {
                                        
                                        float nCeiling;
                                        float nFloor;
                                        nCeiling = (float)(screenHeight / 2.0) - screenHeight / ((float)hitDistance);
                                        nFloor = screenHeight - nCeiling;
                                        //nCeiling = (float)(screenHeight / 2.0) - (screenHeight / ((float)hitDistance)) * (w.height - 1);
                                        
                                        Strip strip = new Strip(new Point(x, nCeiling), new Point(x, nFloor), Color.GREEN);
                                        strip.arrange();
                                        
                                        strips[x].strips.add(strip);
                                        System.out.println(strip);

                                        /*nFloor = nFloor - (screenHeight / ((float)distance)) * (w.z) + (screenHeight / ((float)distance)) * (pz - 1);
                                        nCeiling = nCeiling - (screenHeight / ((float)distance)) * (w.z) + (screenHeight / ((float)distance)) * (pz - 1);

                                        nFloor += (ScreenHeight() / ((float)distance)) * (pz - 1);
                                        nCeiling += (ScreenHeight() / ((float)distance)) * (pz - 1);*/

                                        
                                    }
                                }
                                
                            }
                        }

		}
    }
}
