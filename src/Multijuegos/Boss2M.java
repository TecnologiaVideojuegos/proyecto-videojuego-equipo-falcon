/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multijuegos;

import EstadoBoss2.*;
import EstadoBoss1.Boss1;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
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
public class Boss2M extends BasicGameState {

    private String mapa1 = "Mapas\\boos3.tmx";
    private float puntos1[] = new float[]{50, 30, 800, 30, 800, 780, 50, 780};
    private Polygon bordes;
    private int mapaMov = 0;
    private int a = 0, b = 0, c = 0, d = 0;
    private TiledMap mapa;
    private Nave personaje;
    private ArrayList<Corazones> corazonOut, corazonIn, poum;
    private ArrayList<Arresto> balasOut, balasIn;
    private Corazones heart;
    private Arresto bala;
    private int fase = 0, num = 0;
    private Image[] mundoImg;
    private int contadorMundo = 0;
    private int puntos = 0;

    public Boss2M() {
        try {
            bordes = new Polygon(puntos1);
            Image[] imagenesMundo = {new Image("SpriteBoss2\\Mundo1.png"), new Image("SpriteBoss2\\Mundo2.png"), new Image("SpriteBoss2\\Mundo3.png"), new Image("SpriteBoss2\\Mundo4.png")};
            this.mundoImg = imagenesMundo;
        } catch (SlickException ex) {
        }

    }

    @Override
    public int getID() {
        return 62;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        puntos = 0;
        contadorMundo = 0;
        mapa = new TiledMap(mapa1, "\\Construccion Mapas\\");
        personaje = new Nave();
        personaje.setCoordenadaX(150);
        personaje.setCoordenadaY(400);
        corazonOut = new ArrayList<>();
        balasOut = new ArrayList<>();
        corazonIn = new ArrayList<>();
        balasIn = new ArrayList<>();
        poum = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            heart = new Corazones();
            corazonOut.add(heart);
        }
        for (int i = 0; i < 15; i++) {
            bala = new Arresto();
            balasOut.add(bala);
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);

        if (contadorMundo < 4) {
            g.drawImage(mundoImg[contadorMundo], 0, 0);
        } else {
            try {
                sbg.getState(51).init(gc, sbg);
                sbg.enterState(51, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        for (int i = 0; i < corazonIn.size(); i++) {
            corazonIn.get(i).getDir().draw(corazonIn.get(i).getCoordenadaX(), corazonIn.get(i).getCoordenadaY());
            //g.draw(corazonIn.get(i).getH1());
        }
        for (int i = 0; i < poum.size(); i++) {
            poum.get(i).getDir().draw(poum.get(i).getCoordenadaX(), poum.get(i).getCoordenadaY());
            //g.draw(poum.get(i).getH1());
        }
        for (int i = 0; i < balasIn.size(); i++) {
            balasIn.get(i).getImage().draw(balasIn.get(i).getCoordenadaX(), balasIn.get(i).getCoordenadaY());
            //g.draw(balasIn.get(i).getH1());
        }

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        /*g.draw(personaje.getH1());
         g.draw(personaje.getH2());
         g.draw(personaje.getH3());
         g.draw(personaje.getH4());

         g.draw(bordes);*/
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (puntos > 80) {
            try {
                sbg.getState(51).init(gc, sbg);
                sbg.enterState(51, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Input input = gc.getInput();
        fase++;
        if (fase % 80 == 0) {
            corazonIn.add(corazonOut.get(0));
            corazonOut.remove(0);
            corazonIn.get(corazonIn.size() - 1).init();
            System.out.println(fase / 50);
        }
        if (input.isKeyDown(Input.KEY_SPACE) && fase % 50 == 0) {
            balasIn.add(balasOut.get(0));
            balasOut.remove(0);
            balasIn.get(balasIn.size() - 1).init(personaje.getCoordenadaX() + 30, personaje.getCoordenadaY() + 15);
        }
        for (int x = 0; x < balasIn.size(); x++) {
            balasIn.get(x).move();
            if (balasIn.get(x).getCoordenadaX() >= 1504) {
                balasOut.add(balasIn.get(x));
                balasIn.remove(x);
                balasOut.get(balasOut.size() - 1).reset();
            }
        }
        for (int x = 0; x < corazonIn.size(); x++) {
            corazonIn.get(x).move();
        }
        for (int x = 0; x < corazonIn.size(); x++) {
            Corazones c1 = corazonIn.get(x);
            float x1 = c1.getCoordenadaX();
            if (x1 <= 70) {
                if (contadorMundo == 3) {
                    try {
                        sbg.getState(51).init(gc, sbg);
                        sbg.enterState(51, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                contadorMundo++;
                poum.add(c1);
                c1.explota();
                corazonIn.remove(c1);

            }
            for (int y = 0; y < balasIn.size(); y++) {

                if (c1.getH1().intersects(balasIn.get(y).getH1())) {
                    puntos++;
                    c1.explota();
                    poum.add(c1);
                    corazonIn.remove(c1);
                    balasOut.add(balasIn.get(y));
                    balasIn.remove(y);
                    balasOut.get(balasOut.size() - 1).reset();

                }
            }
        }
        for (int x = 0; x < poum.size(); x++) {
            Corazones h1 = poum.get(x);
            h1.getDir().update(i);
            if (h1.getDir().getFrame() == 3) {
                h1.salir();
                corazonOut.add(h1);
                poum.remove(h1);
            }
        }

        if (input.isKeyDown(Input.KEY_W)) {
            personaje.getDir().update(i);
            for (int n = 0; n < 20; n++) {
                if (personaje.getH1().intersects(bordes)) {
                    a = 1;
                    break;
                } else {
                    a = 0;
                }
            }
            if (a == 0 || b == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.34f);
                b = 0;
            }

        } else if (input.isKeyDown(Input.KEY_S)) {
            personaje.getDir().update(i);
            for (int n = 0; n < 20; n++) {
                if (personaje.getH4().intersects(bordes)) {
                    b = 1;
                    break;
                } else {
                    b = 0;
                }
            }
            if (b == 0 || a == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.34f);
                a = 0;
            }

        } else {
            personaje.getDir().update(i);
        }

    }
}
