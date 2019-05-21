/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Bocadillo;
import Personajes.PersonajePrincipal;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class CinematicaPostColegio extends BasicGameState {

    @Override
    public int getID() {
        return 16;
    }

    Bocadillo bocadilloB1 = new Bocadillo("ini20");
    Bocadillo bocadilloB2 = new Bocadillo("ini21");
    Bocadillo bocadilloB3 = new Bocadillo("ini22");
    Bocadillo bocadilloB4 = new Bocadillo("ini23");
    Bocadillo bocadilloB5 = new Bocadillo("ini24");
    Bocadillo bocadilloB6 = new Bocadillo("ini25");
    int contadorTemporal = 0;

    public CinematicaPostColegio() {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        if (contadorTemporal < 2600) {
            bocadilloB1.dentroXY(100, 0);
            bocadilloB1.getImagen().draw(bocadilloB1.getCoordenadaX(), bocadilloB1.getCoordenadaY());
        } else if (contadorTemporal < 4200) {
            bocadilloB2.dentroXY(100, 0);
            bocadilloB2.getImagen().draw(bocadilloB2.getCoordenadaX(), bocadilloB2.getCoordenadaY());
        } else if (contadorTemporal < 5800) {
            bocadilloB3.dentroXY(100, 0);
            bocadilloB3.getImagen().draw(bocadilloB3.getCoordenadaX(), bocadilloB3.getCoordenadaY());
        } else if (contadorTemporal < 8400) {
            bocadilloB4.dentroXY(100, 0);
            bocadilloB4.getImagen().draw(bocadilloB4.getCoordenadaX(), bocadilloB4.getCoordenadaY());
        }else if (contadorTemporal < 12400) {
            bocadilloB5.dentroXY(100, 0);
            bocadilloB5.getImagen().draw(bocadilloB5.getCoordenadaX(), bocadilloB5.getCoordenadaY());
        } else if (contadorTemporal < 14400) {
            bocadilloB6.dentroXY(100, 0);
            bocadilloB6.getImagen().draw(bocadilloB6.getCoordenadaX(), bocadilloB6.getCoordenadaY());
        } else {
            sbg.enterState(0);
        }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (contadorTemporal < 19000) {
            contadorTemporal++;
        }
    }
}
