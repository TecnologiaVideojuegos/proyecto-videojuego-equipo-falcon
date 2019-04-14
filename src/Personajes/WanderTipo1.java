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
public class WanderTipo1 {
    float coordenadaX = 400 ,coordenadaY= 300;
    Image[] movementUp;
    Image[] movementDown;
    Image[] movementLeft;
    Image[] movementRight; 
    Animation actual, up, down, left, right, stanceright, stanceleft, stanceup, stancedown;
    int[] duration = {200, 200};
    int[] duration2 = {100, 100, 100, 100, 100, 100, 100, 100};
    Rectangle h1,h2,h3,h4;
    
    int movement=0;
    
    public WanderTipo1(String nombre) {
        try {
            
            h1 = new Rectangle(coordenadaX+17, coordenadaY+32, 30, 1);
            h2 = new Rectangle(coordenadaX+16, coordenadaY+33, 1, 30);
            h3 = new Rectangle(coordenadaX+48, coordenadaY+33, 1, 30);
            h4 = new Rectangle(coordenadaX+17, coordenadaY+63, 30, 1);
            
            Image[] movementLeft = {new Image("ImagenesSprite\\izq1.png"), new Image("ImagenesSprite\\izq2.png"), new Image("ImagenesSprite\\izq3.png"), new Image("ImagenesSprite\\izq4.png"), new Image("ImagenesSprite\\izq5.png"), new Image("ImagenesSprite\\izq6.png"), new Image("ImagenesSprite\\izq7.png"), new Image("ImagenesSprite\\izq8.png")};
            Image[] movementRight = {new Image("ImagenesSprite\\der1.png"), new Image("ImagenesSprite\\der2.png"), new Image("ImagenesSprite\\der3.png"), new Image("ImagenesSprite\\der4.png"), new Image("ImagenesSprite\\der5.png"), new Image("ImagenesSprite\\der6.png"), new Image("ImagenesSprite\\der7.png"), new Image("ImagenesSprite\\der8.png")};

            Image[] stanceDown = {new Image("ImagenesSprite\\down0.png"), new Image("ImagenesSprite\\down0.png")}; 
            Image[] stanceUp = {new Image("ImagenesSprite\\up0.png"), new Image("ImagenesSprite\\up0.png")}; 
           
            left = new Animation(movementLeft, duration2, false);
            right = new Animation(movementRight, duration2, false);
            up = new Animation(stanceUp,duration,false);
            down = new Animation(stanceDown,duration,false);
            
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
            
        }
    }
    
    public Animation getDir()
    {
        return actual;
    }
    
    public float getCoordenadaX()
    {
        return this.coordenadaX;
    }
    
    public void move()
    {
        if(movement<200)
        {
            coordenadaX=coordenadaX+(float)(0.5);
            movement++;
            setDir("right");
        }
        else if(movement>=200 && movement <1200)
        {
            movement++;
            setDir("up");
        }
        else if(movement>=1200 && movement <1400)
        {
            movement++;
            coordenadaX=coordenadaX-(float)(0.5);
            setDir("left");
        }
        else if(movement>=1400 && movement <2400)
        {
            movement++;
            setDir("up");
        }
        else
        {
            movement=0;
        }
        h1.setBounds(coordenadaX+17, coordenadaY+32, 30, 1);
        h2.setBounds(coordenadaX+16, coordenadaY+33, 1, 30);
        h3.setBounds(coordenadaX+48, coordenadaY+33, 1,30);
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
