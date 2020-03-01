/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

import java.util.ArrayList;

/**
 *
 * @author child
 */
public class StripCollection {
    ArrayList<Strip> strips = new ArrayList();
    
    StripCollection()
    {
        strips = new ArrayList();
    }
    
    StripCollection(ArrayList<Strip> strips)
    {
        this.strips = strips;
    }
    
}
