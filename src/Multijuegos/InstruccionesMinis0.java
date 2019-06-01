/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multijuegos;

import Estados.Menu2;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author lucas
 */
public class InstruccionesMinis0 extends BasicGameState {

    @Override
    public int getID() {
        return -3;
    }

    public InstruccionesMinis0() {

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        g.drawImage(new Image("\\Elementos Aparte\\Instrucciones\\m1.png"), 150, 0);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        input.disableKeyRepeat();
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            try {
                sbg.getState(61).init(gc, sbg);
                sbg.enterState(61, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(InstruccionesMinis0.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(InstruccionesMinis0.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (input.isKeyPressed(Input.KEY_B)) {
            try {
                sbg.getState(51).init(gc, sbg);
                sbg.enterState(51, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(InstruccionesMinis0.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(InstruccionesMinis0.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
