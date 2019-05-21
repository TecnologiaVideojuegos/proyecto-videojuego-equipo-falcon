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
    TiledMap mapa;

    private float bordes1[] = new float[]{512, 410, 512, 700, 510, 700, 510, 410};
    Polygon borde;

    private float bordes2[] = new float[]{896, 110, 896, 700, 898, 700, 898, 110};
    Polygon salida;

    int contadorParpadeo = 20;
    int contadorTemporal = 0;

    BossFinal boss = new BossFinal("up", 20, 400, 0);
    Fuego fuego = new Fuego("up", 20, 400, "f");

    Historia bocadilloB1 = new Historia("Historia90");
    Historia bocadilloN1 = new Historia("Historia91");
    Historia bocadilloB2 = new Historia("Historia92");
    Historia bocadilloN2 = new Historia("Historia93");
    Historia bocadilloB3 = new Historia("Historia94");
    Historia bocadilloN3 = new Historia("Historia95");
    Historia bocadilloB4 = new Historia("Historia96");
    Historia bocadilloN4 = new Historia("Historia97");
    Historia bocadilloB5 = new Historia("Historia98");
    Historia bocadilloN5 = new Historia("Historia99");
    Historia bocadilloB6 = new Historia("Historia100");
    Historia bocadilloN6 = new Historia("Historia101");

    Boolean choqueIzquierda = false, choqueDerecha = false;
    Music musica;
    PersonajePrincipal personaje = new PersonajePrincipal();

    public Cinematica4() {
        borde = new Polygon(bordes1);
        salida = new Polygon(bordes2);

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        musica = new Music("\\Elementos Aparte\\MusicaDefinitiva\\boss0.wav");

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

                if (contadorTemporal < 2600) {
                    bocadilloB1.dentroXY(100, 0);
                    bocadilloB1.getImagen().draw(bocadilloB1.getCoordenadaX(), bocadilloB1.getCoordenadaY());
                } else if (contadorTemporal < 4200) {
                    bocadilloN1.dentro();
                    bocadilloN1.getImagen().draw(bocadilloN1.getCoordenadaX(), bocadilloN1.getCoordenadaY());
                } else if (contadorTemporal < 5800) {
                    bocadilloB2.dentroXY(100, 0);
                    bocadilloB2.getImagen().draw(bocadilloB2.getCoordenadaX(), bocadilloB2.getCoordenadaY());
                } else if (contadorTemporal < 7400) {
                    bocadilloN2.dentro();
                    bocadilloN2.getImagen().draw(bocadilloN2.getCoordenadaX(), bocadilloN2.getCoordenadaY());
                } else if (contadorTemporal < 9000) {
                    bocadilloB3.dentroXY(100, 0);
                    bocadilloB3.getImagen().draw(bocadilloB3.getCoordenadaX(), bocadilloB3.getCoordenadaY());
                } else if (contadorTemporal < 10600) {
                    bocadilloN3.dentro();
                    bocadilloN3.getImagen().draw(bocadilloN3.getCoordenadaX(), bocadilloN3.getCoordenadaY());
                } else if (contadorTemporal < 12200) {
                    bocadilloB4.dentroXY(100, 0);
                    bocadilloB4.getImagen().draw(bocadilloB4.getCoordenadaX(), bocadilloB4.getCoordenadaY());
                } else if (contadorTemporal < 13800) {
                    bocadilloN4.dentroXY(100, 0);
                    bocadilloN4.getImagen().draw(bocadilloN4.getCoordenadaX(), bocadilloN4.getCoordenadaY());
                } else if (contadorTemporal < 15400) {
                    bocadilloB5.dentro();
                    bocadilloB5.getImagen().draw(bocadilloB5.getCoordenadaX(), bocadilloB5.getCoordenadaY());
                } else if (contadorTemporal < 17000) {
                    bocadilloN4.dentroXY(100, 0);
                    bocadilloN5.getImagen().draw(bocadilloN5.getCoordenadaX(), bocadilloN5.getCoordenadaY());
                } else if (contadorTemporal < 18600) {
                    bocadilloN4.dentroXY(100, 0);
                    bocadilloB6.getImagen().draw(bocadilloB6.getCoordenadaX(), bocadilloB6.getCoordenadaY());
                } else if (contadorTemporal < 20200) {
                    bocadilloN4.dentroXY(100, 0);
                    bocadilloN6.getImagen().draw(bocadilloN6.getCoordenadaX(), bocadilloN6.getCoordenadaY());
                } else {
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
        int velocidad = 1;
        Input input = gc.getInput();
        if (!musica.playing()) {
        musica.setVolume((float) 0.1);
            musica.setPosition(15);
            musica.play();
        }
        boss.getDir().update(i);
        fuego.getDir().update(i);
        if (contadorTemporal < 13850) {
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
