/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Marcador;
import Multijuegos.Boss2M;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Menu2 extends BasicGameState {

    @Override
    public int getID() {
        return 51; //To change body of generated methods, choose Tools | Templates.
    }

    private Marcador marcador = new Marcador(4);

    public Menu2() {

    }
    private TiledMap mapa;
    private Music song;
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\chun.wav");

        mapa = new TiledMap("\\Mapas\\menu2.tmx", "\\Construccion Mapas\\");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        if (!song.playing()) {
            song.play();
            song.setVolume((float) 0.2);
        }
        
        Input input = gc.getInput();
        input.disableKeyRepeat();
        if (input.isKeyPressed(Input.KEY_S)) {
            marcador.setMarcador(+1);
        } else if (input.isKeyPressed(Input.KEY_W)) {
            marcador.setMarcador(-1);
        } else if (input.isKeyPressed(Input.KEY_ENTER)) {
            if (marcador.getMarcador() == 4) {
                try {
                    sbg.getState(53).init(gc, sbg);
                    sbg.enterState(53, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (marcador.getMarcador() == 3) {
                try {
                    sbg.enterState(-3, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (marcador.getMarcador() == 2) {
                try {
                    sbg.enterState(-5, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (marcador.getMarcador() == 1) {
                try {
                    sbg.enterState(-4, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    sbg.enterState(-6, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapa.render(0, 0, 0);
        if (marcador.getMarcador() == 0) {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 540, 345);
        } else if (marcador.getMarcador() == 1) {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 570, 400);
        } else if (marcador.getMarcador() == 2) {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 580, 450);
        } else if (marcador.getMarcador() == 3) {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 585, 505);
        } else {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 585, 555);
        }
    }
}
