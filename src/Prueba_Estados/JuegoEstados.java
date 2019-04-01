/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba_Estados;

import Juego.BOSS1;
import Juego.BuclePrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author lucas
 */
public class JuegoEstados extends StateBasedGame {

    private AppGameContainer contenedor;
    
    public JuegoEstados(String name) {
        super(name);
        try {
            contenedor = new AppGameContainer(this);
            contenedor.setDisplayMode(1504, 800, false);
            contenedor.start();
        } catch (SlickException ex) {
            Logger.getLogger(JuegoEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new BuclePrincipal(0));
        this.addState(new BOSS1());
                            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        new JuegoEstados("a");
    }
    
}
