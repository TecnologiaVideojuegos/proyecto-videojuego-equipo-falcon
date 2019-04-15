/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class ProfEd {
    
    Image[] throwBall; 
    Animation throwing;
    int[] duration = {200, 200};
    int[] duration2 = {1500, 100, 100, 100, 100, 1100};
    
    public ProfEd() {
        try {
            Image[] throwBall = {new Image("SpriteBoss1\\1.png"), new Image("SpriteBoss1\\2.png"), new Image("SpriteBoss1\\3.png"), new Image("SpriteBoss1\\4.png"), new Image("SpriteBoss1\\5.png"), new Image("SpriteBoss1\\6.png")};
            throwing = new Animation(throwBall, duration2, false);
            
        }catch (SlickException e) {
        }
    }
    
    public Animation getDir()
    {
        return throwing;
    }
    
}
