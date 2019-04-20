/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import EstadoBoss1.Boss1;
import EstadoBoss2.Boss2;
import Estados.Mundo;
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
public class Juego extends StateBasedGame {

    private AppGameContainer contenedor;

    public Juego(String name) {
        super(name);
        try {
            contenedor = new AppGameContainer(this);
            contenedor.setDisplayMode(1504, 800, false);
            contenedor.start();
        } catch (SlickException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
       
        this.addState(new Mundo(1));
        this.addState(new Boss1());
        this.addState(new Boss2());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Juego("a");
    }

}
