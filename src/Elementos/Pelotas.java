/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Pelotas {
    float coordenadaX = 300 ,coordenadaY= 300;
    Image[] movement; 
    Animation left, right, actual;

    int[] duration = {100, 100, 100, 100};
    Circle c1;
    
    public Pelotas() {
        try {
            
            
            c1 = new Circle(coordenadaX+32, coordenadaY+32,48);
            
            Image[] movementR = {new Image("balones.png"), new Image("balones1.png"), new Image("balones2.png"), new Image("balones3.png")};
            Image[] movementL = {new Image("balones.png"), new Image("balones3.png"), new Image("balones2.png"), new Image("balones1.png")};
           
            right = new Animation(movementR, duration, false);
            left  = new Animation(movementL, duration, false);
            
            actual = right;
        } catch (SlickException e) {
        }
    }
    
    public void setDir(String string)
    {
        
        switch (string) {
            case "right":
                actual = right;
                break;
            case "left":
                actual = left;
                break;
        }
    }
    
    public Animation getDir()
    {
        return actual;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
        c1.setLocation(coordenadaX+32, coordenadaY+32);
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {
       
        this.coordenadaY = coordenadaY;
        c1.setLocation(coordenadaX+32, coordenadaY+32);
        
    }
    
    public Circle getC1() {
        return c1;
    }
    
}
