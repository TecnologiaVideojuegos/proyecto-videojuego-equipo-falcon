/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import Personajes.BossFinal;
import Personajes.PersonajeAcosador;
import Personajes.PersonajePrincipal;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.*;

/**
 *
 * @author lucas
 */
public class FIN1 extends BasicGameState {

    @Override
    public int getID() {
        return 29; //To change body of generated methods, choose Tools | Templates.
    }

    private static TiledMap mapa;
    private PersonajePrincipal personaje;

    private BossFinal boss = new BossFinal("up", 20, 400, 1);
    private PersonajeAcosador padre = new PersonajeAcosador("down", 930, 380, "N2", "Padre");

    private boolean historia = false;
    private int contadorTemporal1 = 0, contadorTemporal2 = 0;
    private Music song;
    private Historia b1 = new Historia("Historia120");
    private Historia b2 = new Historia("Historia121");
    private Historia b3 = new Historia("Historia122");
    private Historia b4 = new Historia("Historia123");
    private Historia b5 = new Historia("Historia124");
    private Historia b6 = new Historia("Historia125");
    private Historia b7 = new Historia("Historia126");
    private Historia b8 = new Historia("Historia127");

    public FIN1() {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\Boss0eew.wav");
        mapa = new TiledMap("\\Mapas\\mapa9Noche.tmx", "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(368);
        personaje.setCoordenadaY(703);
        personaje.setDir("up");

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
        boss.getDir().update(i);
        padre.getDir().update(i);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();

        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        padre.getDir().draw(140, 350);
        boss.getDir().draw(368, 350);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        if (contadorTemporal1 > 0 && contadorTemporal1 < 1500) {
            if (personaje.getCoordenadaY() > 500) {
                personaje.setDir("up");
                personaje.setCoordenadaY(personaje.getCoordenadaY() - (float) 0.5);
            } else if (personaje.getCoordenadaX() > 140) {
                personaje.setDir("left");
                personaje.setCoordenadaX(personaje.getCoordenadaX() - (float) 0.5);
            } else if (personaje.getCoordenadaY() > 410) {
                personaje.setDir("up");
                personaje.setCoordenadaY(personaje.getCoordenadaY() - (float) 0.5);
            } else {
                personaje.setDir("stance");
            }
        } else if (contadorTemporal1 > 1500 && contadorTemporal1 < 2800) {
            b1.dentro();
            b1.getImagen().draw(b1.getCoordenadaX(), b1.getCoordenadaY());
        } else if (contadorTemporal1 > 2800 && contadorTemporal1 < 4400) {
            b2.dentro();
            b2.getImagen().draw(b2.getCoordenadaX(), b2.getCoordenadaY());
        } else if (contadorTemporal1 > 4400 && contadorTemporal1 < 6000) {
            personaje.setDir("right");
            personaje.setDir("stance");
            padre.setDir("sright");
            b3.dentro();
            b3.getImagen().draw(b3.getCoordenadaX(), b3.getCoordenadaY());
        } else if (contadorTemporal1 > 6000 && contadorTemporal1 < 8000) {
            b4.dentro();
            b4.getImagen().draw(b4.getCoordenadaX(), b4.getCoordenadaY());
        } else if (contadorTemporal1 > 8000 && contadorTemporal1 < 10500) {
            b5.dentro();
            b5.getImagen().draw(b5.getCoordenadaX(), b5.getCoordenadaY());
        } else if (contadorTemporal1 > 10500 && contadorTemporal1 < 12300) {
            b6.dentro();
            b6.getImagen().draw(b6.getCoordenadaX(), b6.getCoordenadaY());
        } else if (contadorTemporal1 > 12300 && contadorTemporal1 < 14100) {
            b7.dentro();
            b7.getImagen().draw(b7.getCoordenadaX(), b7.getCoordenadaY());
        } else if (contadorTemporal1 > 14100 && contadorTemporal1 < 15700) {
            b8.dentro();
            b8.getImagen().draw(b8.getCoordenadaX(), b8.getCoordenadaY());
        } else if (contadorTemporal1 > 15700) {
            sbg.enterState(32);
        }

    }
}
