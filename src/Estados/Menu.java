/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Marcador;
import EstadoBoss1.Boss1;
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
public class Menu extends BasicGameState {

    @Override
    public int getID() {
        return 53; //To change body of generated methods, choose Tools | Templates.
    }
    private Music song;
    private Marcador marcador = new Marcador(2);

    public Menu() {

    }
    private TiledMap mapa;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\chun.wav");

        mapa = new TiledMap("\\Mapas\\menu.tmx", "\\Construccion Mapas\\");
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
            if (marcador.getMarcador() == 2) {
                gc.exit();
            } else if (marcador.getMarcador() == 0) {
                
                try {
                    sbg.enterState(-2, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                            
            } else {
                try {
                    sbg.enterState(51, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapa.render(0, 0, 0);
        if (marcador.getMarcador() == 0) {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 520, 360);
        } else if (marcador.getMarcador() == 1) {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 560, 430);
        } else {
            g.drawImage(new Image("\\Elementos Aparte\\marcador.png"), 630, 500);
        }
    }
}
