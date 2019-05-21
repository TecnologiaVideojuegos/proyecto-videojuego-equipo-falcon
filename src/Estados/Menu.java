/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Marcador;
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
public class Menu extends BasicGameState {

    @Override
    public int getID() {
        return 53; //To change body of generated methods, choose Tools | Templates.
    }

    Marcador marcador = new Marcador(2);
    public Menu() {

    }
    TiledMap mapa;
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        mapa = new TiledMap("\\Mapas\\menu.tmx", "\\Construccion Mapas\\");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        input.disableKeyRepeat();
        if(input.isKeyPressed(Input.KEY_S))
        {
            marcador.setMarcador(+1);
        } else if(input.isKeyPressed(Input.KEY_W))
        {
            marcador.setMarcador(-1);
        }else if(input.isKeyPressed(Input.KEY_ENTER))
        {
            if(marcador.getMarcador()==2)
            {
                gc.exit();
            }else if(marcador.getMarcador()==0)
            {
                sbg.enterState(8);
            }else
            {
                sbg.enterState(51);
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
     mapa.render(0, 0, 0);
     if(marcador.getMarcador()==0)
        g.drawImage(new Image("\\Elementos Aparte\\marcador.png"),520,360);
     else if(marcador.getMarcador()==1)
         g.drawImage(new Image("\\Elementos Aparte\\marcador.png"),560,430);
     else
         g.drawImage(new Image("\\Elementos Aparte\\marcador.png"),630,500);
    }
}
