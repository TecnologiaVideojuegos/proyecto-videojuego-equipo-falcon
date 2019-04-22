/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Elementos.Alerta;
import Elementos.Bocadillo;
import Mapas.Mapa2;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class EscalerasPlaya extends WanderTipoT {

    float coordenadaX , coordenadaY;
    Rectangle hitbox;

    public EscalerasPlaya() {
        
            sgb=10;
            //Colocacion personaje
            this.coordenadaX =-1000;
            this.coordenadaY =-1000;
            
            //Creacion hitbox
            hitbox = new Rectangle(66, 797, 186, 1);   
    }
    
  

    

    public float getCoordenadaX() {
        return this.coordenadaX;
    }

    public float getCoordenadaY() {
        return this.coordenadaY;
    }

    @Override
    public void move() {
        hitbox.setBounds(66, 797, 186, 1);  
    }


    public Rectangle getHitbox() {
        return hitbox;
    }

    public void talk() {
       
    }

    
    public void noTalk() {
        bocadillo.fuera();
    }
    
   
    
    public void alerta() {
        }
    
    public void noAlerta() {
        alerta.fuera();
    }
    
    public boolean isSGB()
    {
        return sgb!=-1;
    }
    
    public int getSGB()
    {
        return sgb;
    }
    
    public void notSGB()
    {
        sgb=-1;
    }
    
    public void hide()
    {
        hitbox.setBounds(0, 0, 0, 0);
    }

}
