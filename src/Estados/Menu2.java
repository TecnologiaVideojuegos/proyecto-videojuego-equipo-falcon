/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Marcador;
import Multijuegos.Boss2M;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
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

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        mapa = new TiledMap("\\Mapas\\menu2.tmx", "\\Construccion Mapas\\");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        input.disableKeyRepeat();
        if (input.isKeyPressed(Input.KEY_S)) {
            marcador.setMarcador(+1);
        } else if (input.isKeyPressed(Input.KEY_W)) {
            marcador.setMarcador(-1);
        } else if (input.isKeyPressed(Input.KEY_ENTER)) {
            if (marcador.getMarcador() == 4) {
                sbg.getState(53).init(gc, sbg);
                sbg.enterState(53);
            } else if (marcador.getMarcador() == 3) {
                sbg.enterState(61);
                sbg.getState(61).init(gc, sbg);
            } else if (marcador.getMarcador() == 2) {
                sbg.enterState(63);
                sbg.getState(63).init(gc, sbg);
            } else if (marcador.getMarcador() == 1) {
                sbg.getState(62).init(gc, sbg);
                sbg.enterState(62);
            } else {
                sbg.enterState(64);
                sbg.getState(64).init(gc, sbg);
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
