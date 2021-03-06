/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import EstadoBoss1.Boss1;
import Personajes.BossFinal;
import Personajes.Fuego;
import Personajes.PersonajePrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Cinematica4 extends BasicGameState {

    @Override
    public int getID() {
        return 26;
    }

    private String mapa1 = "Mapas\\BossHola.tmx";
    private TiledMap mapa;

    private float bordes1[] = new float[]{512, 410, 512, 700, 510, 700, 510, 410};
    private Polygon borde;

    private float bordes2[] = new float[]{896, 110, 896, 700, 898, 700, 898, 110};
    private Polygon salida;

    private int contadorParpadeo = 20;
    private int contadorTemporal = 0;

    private BossFinal boss = new BossFinal("up", 20, 400, 0);
    private Fuego fuego = new Fuego("up", 20, 400, "f");

    private Historia bocadilloB1 = new Historia("Historia90");
    private Historia bocadilloN1 = new Historia("Historia91");
    private Historia bocadilloB2 = new Historia("Historia92");
    private Historia bocadilloN2 = new Historia("Historia93");
    private Historia bocadilloB3 = new Historia("Historia94");
    private Historia bocadilloN3 = new Historia("Historia95");
    private Historia bocadilloB4 = new Historia("Historia96");
    private Historia bocadilloN4 = new Historia("Historia97");
    private Historia bocadilloB5 = new Historia("Historia98");
    private Historia bocadilloN5 = new Historia("Historia99");
    private Historia bocadilloB6 = new Historia("Historia100");
    private Historia bocadilloN6 = new Historia("Historia101");

    private Music song;
    private Boolean choqueIzquierda = false, choqueDerecha = false;
    private PersonajePrincipal personaje = new PersonajePrincipal();
    private boolean stop = true;

    public Cinematica4() {
        borde = new Polygon(bordes1);
        salida = new Polygon(bordes2);

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\Boss0.wav");

        mapa = new TiledMap(mapa1, "\\Construccion Mapas\\");
        personaje.setCoordenadaX(662);
        personaje.setCoordenadaY(540);
        personaje.setDir("up");
        personaje.setDir("stance");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapa.render(0, 0, 0);
        personaje.getDir().draw(personaje.getCoordenadaX(), personaje.getCoordenadaY());
        boss.getDir().draw(500, 200);
        fuego.getDir().draw(0, 740);
        if (true) {
            if (contadorTemporal > 1000) {

                if (contadorTemporal < 2800) {
                    bocadilloB1.dentroXY(100, 0);
                    bocadilloB1.getImagen().draw(bocadilloB1.getCoordenadaX(), bocadilloB1.getCoordenadaY());
                } else if (contadorTemporal < 4600) {
                    bocadilloN1.dentro();
                    bocadilloN1.getImagen().draw(bocadilloN1.getCoordenadaX(), bocadilloN1.getCoordenadaY());
                } else if (contadorTemporal < 6400) {
                    bocadilloB2.dentroXY(100, 0);
                    bocadilloB2.getImagen().draw(bocadilloB2.getCoordenadaX(), bocadilloB2.getCoordenadaY());
                } else if (contadorTemporal < 8400) {
                    bocadilloN2.dentro();
                    bocadilloN2.getImagen().draw(bocadilloN2.getCoordenadaX(), bocadilloN2.getCoordenadaY());
                } else if (contadorTemporal < 10200) {
                    bocadilloB3.dentroXY(100, 0);
                    bocadilloB3.getImagen().draw(bocadilloB3.getCoordenadaX(), bocadilloB3.getCoordenadaY());
                } else if (contadorTemporal < 12200) {
                    bocadilloN3.dentro();
                    bocadilloN3.getImagen().draw(bocadilloN3.getCoordenadaX(), bocadilloN3.getCoordenadaY());
                } else if (contadorTemporal < 16500) {
                    bocadilloB4.dentroXY(100, 0);
                    bocadilloB4.getImagen().draw(bocadilloB4.getCoordenadaX(), bocadilloB4.getCoordenadaY());
                } else if (contadorTemporal < 19200) {
                    bocadilloN4.dentroXY(100, 0);
                    bocadilloN4.getImagen().draw(bocadilloN4.getCoordenadaX(), bocadilloN4.getCoordenadaY());
                } else if (contadorTemporal < 21000) {
                    bocadilloB5.dentro();
                    bocadilloB5.getImagen().draw(bocadilloB5.getCoordenadaX(), bocadilloB5.getCoordenadaY());
                } else if (contadorTemporal < 24100) {
                    bocadilloN5.dentroXY(100, 0);
                    bocadilloN5.getImagen().draw(bocadilloN5.getCoordenadaX(), bocadilloN5.getCoordenadaY());
                } else if (contadorTemporal < 26700) {
                    bocadilloB6.dentroXY(100, 0);
                    bocadilloB6.getImagen().draw(bocadilloB6.getCoordenadaX(), bocadilloB6.getCoordenadaY());
                } else if (contadorTemporal < 30000) {
                    bocadilloN6.dentroXY(100, 0);
                    bocadilloN6.getImagen().draw(bocadilloN6.getCoordenadaX(), bocadilloN6.getCoordenadaY());
                } else if (stop) {
                    stop = false;
                    try {
                        sbg.enterState(27, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        if (!song.playing()) {
            song.setPosition((float) 12.55);
            song.play();
            song.setVolume((float) 0.2);
        }

        int velocidad = 1;
        Input input = gc.getInput();
        boss.getDir().update(i);
        fuego.getDir().update(i);
        if (contadorTemporal < 30000) {
            contadorTemporal++;
        } else {
            if (input.isKeyDown(Input.KEY_A)) {
                personaje.setDir("left");
                personaje.getDir().update(i);
                if (personaje.getH2().intersects(borde)) {
                    choqueIzquierda = true;
                } else {
                    choqueIzquierda = false;
                }
                if (!choqueIzquierda || choqueDerecha) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f * velocidad);
                    choqueDerecha = false;
                }
            } else if (input.isKeyDown(Input.KEY_D)) {
                personaje.setDir("right");
                personaje.getDir().update(i);
                if (personaje.getH3().intersects(borde)) {
                    choqueDerecha = true;
                } else {
                    choqueDerecha = false;
                }
                if (!choqueDerecha || choqueIzquierda) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);
                    if (personaje.getH3().intersects(salida)) {
                        personaje.setCoordenadaX(700);
                        personaje.setCoordenadaY(470);
                        personaje.setDir("up");
                        personaje.setDir("stance");
                        sbg.getState(20).init(gc, sbg);
                        sbg.enterState(20);// --> BOSS3
                    }
                }
                choqueIzquierda = false;
            } else {
                personaje.setDir("stance");
                personaje.getDir().update(i);
            }

        }
    }
}
