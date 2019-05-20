/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class PasoCompra extends PersonajeGeneral {


    public PasoCompra() {
        
            sgb=23;
            //Colocacion personaje
            this.coordenadaX =-1000;
            this.coordenadaY =-1000;
            
            //Creacion hitbox
            hitbox = new Rectangle(1500, 0, 1, 800);   
    }
    @Override
    public void move() {
        hitbox.setBounds(1500, 0, 1, 800);
    }
    
    @Override
    public void talk() {
    }

    @Override
    public void alerta() {
    }

}
