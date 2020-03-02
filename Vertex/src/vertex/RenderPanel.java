
package vertex;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author cstuser
 */


public class RenderPanel extends JPanel implements KeyListener{
    
    
    public RenderPanel() {
        addKeyListener(this);
        setFocusable(true);
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.gray);
        g.drawString(Long.toString(Game.deltaTime), 10, 10);
      
        for(int x = 0; x < Renderer.screenWidth; x++)
        {
            System.out.println("} " + x);
            System.out.println("Cheking if can render...");
            if(Renderer.strips[x].render)
            {
                for(Strip strip : Renderer.strips[x].strips)
                {
                        System.out.println("rendering " + x);
                        System.out.println(strip.color);
                        g.setColor(strip.color);
                        System.out.println(strip.screenCoordinates[0].x + " " + strip.screenCoordinates[0].y);
                        g.drawLine((int) strip.screenCoordinates[0].x, (int) strip.screenCoordinates[0].y, (int) strip.screenCoordinates[1].x, (int) strip.screenCoordinates[1].y);
                }
            }
        }
    }
    
   
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
               
                break;
            case KeyEvent.VK_DOWN:
                Game.panel.repaint();
                break;
            case KeyEvent.VK_LEFT:
                Game.player.position.x += 1;
                break;
            case KeyEvent.VK_RIGHT:
              
                break;
            case KeyEvent.VK_SPACE:
               
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
            case KeyEvent.VK_1:             
                break;
            case KeyEvent.VK_2:
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
