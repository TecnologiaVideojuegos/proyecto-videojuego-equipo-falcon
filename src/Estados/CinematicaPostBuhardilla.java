/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import EstadoBoss1.Boss1;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author lucas
 */
public class CinematicaPostBuhardilla extends BasicGameState {

    @Override
    public int getID() {
        return 14;
    }

    private Historia bocadilloB1 = new Historia("ini0");
    private Historia bocadilloB2 = new Historia("ini1");
    private Historia bocadilloB3 = new Historia("ini2");
    private Historia bocadilloB4 = new Historia("ini3");
    private Historia bocadilloB5 = new Historia("ini4");
    private Historia bocadilloB6 = new Historia("ini5");
    private Historia bocadilloB7 = new Historia("ini6");

    private int contadorTemporal = 0;
    private boolean stop = true;

    public CinematicaPostBuhardilla() {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        if (contadorTemporal < 2600) {
            bocadilloB1.dentroXY(100, 0);
            bocadilloB1.getImagen().draw(bocadilloB1.getCoordenadaX(), bocadilloB1.getCoordenadaY());
        } else if (contadorTemporal < 4600) {
            bocadilloB2.dentroXY(100, 0);
            bocadilloB2.getImagen().draw(bocadilloB2.getCoordenadaX(), bocadilloB2.getCoordenadaY());
        } else if (contadorTemporal < 6600) {
            bocadilloB3.dentroXY(100, 0);
            bocadilloB3.getImagen().draw(bocadilloB3.getCoordenadaX(), bocadilloB3.getCoordenadaY());
        } else if (contadorTemporal < 10800) {
            bocadilloB4.dentroXY(100, 0);
            bocadilloB4.getImagen().draw(bocadilloB4.getCoordenadaX(), bocadilloB4.getCoordenadaY());
        } else if (contadorTemporal < 14800) {
            bocadilloB5.dentroXY(100, 0);
            bocadilloB5.getImagen().draw(bocadilloB5.getCoordenadaX(), bocadilloB5.getCoordenadaY());
        } else if (contadorTemporal < 16400) {
            bocadilloB6.dentroXY(100, 0);
            bocadilloB6.getImagen().draw(bocadilloB6.getCoordenadaX(), bocadilloB6.getCoordenadaY());
        } else if (contadorTemporal < 18000) {
            bocadilloB7.dentroXY(100, 0);
            bocadilloB7.getImagen().draw(bocadilloB7.getCoordenadaX(), bocadilloB7.getCoordenadaY());
        } else if (stop) {
            stop = false;
            try {

                sbg.enterState(0, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        contadorTemporal++;

    }
}
