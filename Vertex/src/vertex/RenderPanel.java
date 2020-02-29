
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
        this.setBackground(Color.BLACK);
        Color c = new Color(5, 8, 6);
        Line l = new Line();
        g.drawString(Integer.toString(Game.word), 10, 100); 
    }
    
   
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
               
                break;
            case KeyEvent.VK_DOWN:
                
                break;
            case KeyEvent.VK_LEFT:
                
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
