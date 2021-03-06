/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import EstadoBoss1.Boss1;
import Personajes.BossFinal;
import Personajes.PersonajeAcosador;
import Personajes.PersonajePrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.*;

/**
 *
 * @author lucas
 */
public class FIN2 extends BasicGameState {

    @Override
    public int getID() {
        return 30; //To change body of generated methods, choose Tools | Templates.
    }

    private static TiledMap mapa;
    private PersonajePrincipal personaje;

    private BossFinal boss = new BossFinal("up", 20, 400, 2);
    private PersonajeAcosador padre = new PersonajeAcosador("down", 930, 380, "N2", "Padre");

    private boolean historia = false, stop = true;
    private int contadorTemporal1 = -1800, contadorTemporal2 = 0;

    private Music song;
    private Historia b1 = new Historia("Historia132");
    private Historia b2 = new Historia("Historia133");
    private Historia b3 = new Historia("Historia134");
    private Historia b4 = new Historia("Historia135");
    private Historia b5 = new Historia("Historia136");
    private Historia b6 = new Historia("Historia137");
    private Historia b7 = new Historia("Historia138");
    private Historia b8 = new Historia("Historia139");
    private Historia b9 = new Historia("Historia140");
    private Historia b10 = new Historia("Historia141");
    private Historia b11 = new Historia("Historia142");

    public FIN2() {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\fin.wav");
        mapa = new TiledMap("\\Mapas\\mapa9Noche.tmx", "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(140);
        personaje.setCoordenadaY(410);
        personaje.setDir("up");
        personaje.setDir("stance");
        padre.setCoordenadas(140, 350);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        if (!song.playing()) {
            song.setPosition((float) 12.55);
            song.play();
            song.setVolume((float) 0.2);
        }

        Input input = gc.getInput();
        contadorTemporal1++;
        personaje.getDir().update(i);
        if (boss.getDir().getFrame() != 11) {
            boss.getDir().update(i);
        }
        padre.getDir().update(i);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();

        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        padre.getDir().draw(padre.getCoordenadaX(), padre.getCoordenadaY());
        if (boss.getDir().getFrame() != 11) {
            boss.getDir().draw(368, 350);
        }
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        if (contadorTemporal1 > -1800 && contadorTemporal1 < 0) {
            b1.dentro();
            b1.getImagen().draw(b1.getCoordenadaX(), b1.getCoordenadaY());
        } else if (contadorTemporal1 > 0 && contadorTemporal1 < 2000) {
            b2.dentro();
            b2.getImagen().draw(b2.getCoordenadaX(), b2.getCoordenadaY());
        } else if (contadorTemporal1 > 2000 && contadorTemporal1 < 3800) {
            b3.dentro();
            b3.getImagen().draw(b3.getCoordenadaX(), b3.getCoordenadaY());
        } else if (contadorTemporal1 > 3800 && contadorTemporal1 < 6000) {
            b4.dentro();
            b4.getImagen().draw(b4.getCoordenadaX(), b4.getCoordenadaY());
        } else if (contadorTemporal1 > 6000 && contadorTemporal1 < 10200) {
            b5.dentro();
            b5.getImagen().draw(b5.getCoordenadaX(), b5.getCoordenadaY());
        } else if (contadorTemporal1 > 10200 && contadorTemporal1 < 13700) {
            b6.dentro();
            b6.getImagen().draw(b6.getCoordenadaX(), b6.getCoordenadaY());
        } else if (contadorTemporal1 > 13700 && contadorTemporal1 < 15700)  {
            b7.dentro();
            b7.getImagen().draw(b7.getCoordenadaX(), b7.getCoordenadaY());
        } else if (contadorTemporal1 > 15700 && contadorTemporal1 < 17700) {
            b8.dentro();
            b8.getImagen().draw(b8.getCoordenadaX(), b8.getCoordenadaY());
        } else if (contadorTemporal1 > 17700 && contadorTemporal1 < 19300) {
            b9.dentro();
            b9.getImagen().draw(b9.getCoordenadaX(), b9.getCoordenadaY());
        } else if (contadorTemporal1 > 19300 && contadorTemporal1 < 20900) {
            b10.dentro();
            b10.getImagen().draw(b10.getCoordenadaX(), b10.getCoordenadaY());
        } else if (contadorTemporal1 > 20900 && contadorTemporal1 < 23300) {
            b11.dentro();
            b11.getImagen().draw(b11.getCoordenadaX(), b11.getCoordenadaY());
        } else if (contadorTemporal1 > 23300 && contadorTemporal1 < 24600) {
            padre.setCoordenadas(padre.getCoordenadaX(), padre.getCoordenadaY() - (float) 0.3);
        } else if (contadorTemporal1 > 24600 && stop) {
            stop = false;
            try {
                sbg.enterState(50, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
