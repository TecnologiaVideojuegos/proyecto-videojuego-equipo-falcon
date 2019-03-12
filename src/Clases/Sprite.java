/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Sprite {
    float coordenadaX = 300 ,coordenadaY= 300;
    Image[] movementUp;
    Image[] movementDown;
    Image[] movementLeft;
    Image[] movementRight; 
    Animation actual, up, down, left, right, stanceright, stanceleft, stanceup, stancedown;
    int[] duration = {200, 200};
    int[] duration2 = {100, 100, 100, 100, 100, 100, 100, 100};
    Rectangle h1,h2,h3,h4;
    
    public Sprite() {
        try {
            
            
            
            h1 = new Rectangle(coordenadaX+17, coordenadaY+32, 30, 1);
            h2 = new Rectangle(coordenadaX+16, coordenadaY+33, 1, 30);
            h3 = new Rectangle(coordenadaX+48, coordenadaY+33, 1, 30);
            h4 = new Rectangle(coordenadaX+17, coordenadaY+64, 30, 1);
            
            Image[] movementUp = {new Image("imagenesSprite\\up1.png"), new Image("imagenesSprite\\up2.png")};
            Image[] movementDown = {new Image("imagenesSprite\\down1.png"), new Image("imagenesSprite\\down2.png")};
            Image[] movementLeft = {new Image("imagenesSprite\\izq1.png"), new Image("imagenesSprite\\izq2.png"), new Image("imagenesSprite\\izq3.png"), new Image("imagenesSprite\\izq4.png"), new Image("imagenesSprite\\izq5.png"), new Image("imagenesSprite\\izq6.png"), new Image("imagenesSprite\\izq7.png"), new Image("imagenesSprite\\izq8.png")};
            Image[] movementRight = {new Image("imagenesSprite\\der1.png"), new Image("imagenesSprite\\der2.png"), new Image("imagenesSprite\\der3.png"), new Image("imagenesSprite\\der4.png"), new Image("imagenesSprite\\der5.png"), new Image("imagenesSprite\\der6.png"), new Image("imagenesSprite\\der7.png"), new Image("imagenesSprite\\der8.png")};

            Image[] stanceRight = {new Image("imagenesSprite\\der0.png"), new Image("imagenesSprite\\der0.png")}; 
            Image[] stanceLeft = {new Image("imagenesSprite\\izq0.png"), new Image("imagenesSprite\\izq0.png")}; 
            Image[] stanceDown = {new Image("imagenesSprite\\down0.png"), new Image("imagenesSprite\\down0.png")}; 
            Image[] stanceUp = {new Image("imagenesSprite\\up0.png"), new Image("imagenesSprite\\up0.png")}; 
           
            up = new Animation(movementUp, duration, false);
            down = new Animation(movementDown, duration, false);
            left = new Animation(movementLeft, duration2, false);
            right = new Animation(movementRight, duration2, false);
            stanceleft = new Animation(stanceLeft,duration,false);
            stanceright = new Animation(stanceRight,duration,false);
            stanceup = new Animation(stanceUp,duration,false);
            stancedown = new Animation(stanceDown,duration,false);
            
            actual = right;
        } catch (SlickException e) {
        }
    }
    
    public void setDir(String string)
    {
        
        switch (string) {
            case "up":
                actual = up;
                break;
            case "down":
                actual = down;
                break;
            case "right":
                actual = right;
                break;
            case "left":
                actual = left;
                break;
            case "stance":
                if(actual == right)
                    actual = stanceright;
                else if(actual == left)
                    actual = stanceleft;
                else if(actual == down)
                    actual = stancedown;
                else if(actual == up)
                    actual = stanceup;
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
        h1.setBounds(coordenadaX+17, coordenadaY+32, 30, 1);
        h2.setBounds(coordenadaX+16, coordenadaY+33, 1, 30);
        h3.setBounds(coordenadaX+48, coordenadaY+33, 1,30);
        h4.setBounds(coordenadaX+17, coordenadaY+64, 30, 1);
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {
       
        this.coordenadaY = coordenadaY;
        h1.setBounds(coordenadaX+17, coordenadaY+32, 30, 1);
        h2.setBounds(coordenadaX+16, coordenadaY+33, 1, 30);
        h3.setBounds(coordenadaX+48, coordenadaY+33, 1, 30);
        h4.setBounds(coordenadaX+17, coordenadaY+64, 30, 1);
        
    }
    
    public Rectangle getH1() {
        return h1;
    }

    public Rectangle getH2() {
        return h2;
    }

    public Rectangle getH3() {
        return h3;
    }

    public Rectangle getH4() {
        return h4;
    }
    
}
