/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Boton extends PersonajeGeneral {

    int[] duration2 = {500, 500};
    Animation actual,changes;
    int num;
    public Boton(int a) {
        try {
            num=a;
            Image[] movement = {new Image("SpriteBoss4\\-2.png"), new Image("SpriteBoss4\\-2.png")};
            Image[] change = {new Image("SpriteBoss4\\"+a+".png"), new Image("SpriteBoss4\\"+a+".png")};
            changes = new Animation(change,duration2,false);
            actual = new Animation(movement, duration2, false);
            
            //Creacion hitbox
            hitbox = new Rectangle(1238, 385, 50, 1);   
        } catch (SlickException ex) {
            Logger.getLogger(Boton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getNum()
    {
        return num;
    }
    
    public boolean check(int x, int y)
    {
        if(x>coordenadaX && x<coordenadaX+64 && y>coordenadaY && y<coordenadaY+64){
            
            actual = changes;
            return true;
        }
        else{
            return false;}
    }
    
    @Override
    public Animation getDir()
    {
        return actual;
    }
    
    @Override
    public void move() {
        hitbox.setBounds(1238, 385, 50, 1); 
    }
    
    public void setCoordenadas(int x, int y)
    {
        this.coordenadaX=x;
        this.coordenadaY=y;
    }
    
    @Override
    public void talk() {
    }

    @Override
    public void alerta() {
    }

}
