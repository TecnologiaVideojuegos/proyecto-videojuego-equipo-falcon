/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Arresto;
import Elementos.Corazones;
import Personajes.Nave;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Boss2 extends BasicGameState {

    private String mapa1 = "Mapas\\boos3.tmx";
    private float puntos1[] = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
    private Polygon bordes;
    int first = 10;
    int mapaMov = 0;
    int a = 0, b = 0, c = 0, d = 0;
    TiledMap mapa;
    Nave personaje;
    ArrayList<Corazones> corazonOut, corazonIn, poum;
    ArrayList<Arresto> balasOut, balasIn;
    Corazones heart;
    Arresto bala;
    int fase = 0, num = 0;

    public Boss2() {
        bordes = new Polygon(puntos1);

    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
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
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        for (int i = 0; i < corazonIn.size(); i++) {
            corazonIn.get(i).getDir().draw(corazonIn.get(i).getCoordenadaX(), corazonIn.get(i).getCoordenadaY());
            g.draw(corazonIn.get(i).getH1());
        }
        for (int i = 0; i < poum.size(); i++) {
            poum.get(i).getDir().draw(poum.get(i).getCoordenadaX(), poum.get(i).getCoordenadaY());
            g.draw(poum.get(i).getH1());
        }
        for (int i = 0; i < balasIn.size(); i++) {
            balasIn.get(i).getImage().draw(balasIn.get(i).getCoordenadaX(), balasIn.get(i).getCoordenadaY());
            g.draw(balasIn.get(i).getH1());
        }

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        g.draw(personaje.getH1());
        g.draw(personaje.getH2());
        g.draw(personaje.getH3());
        g.draw(personaje.getH4());

        g.draw(bordes);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        Input input = gc.getInput();
        fase++;
        if (fase % 100 == 0) {
            corazonIn.add(corazonOut.get(0));
            corazonOut.remove(0);
            corazonIn.get(corazonIn.size() - 1).init();
            System.out.println(fase / 50);
        }
        if (input.isKeyDown(Input.KEY_SPACE) && fase %50 == 0) {
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
            if(x1<=200)
            {
                poum.add(c1);
                c1.explota();
                corazonIn.remove(c1);
            }
            for (int y = 0; y < balasIn.size(); y++) {

                if (c1.getH1().intersects(balasIn.get(y).getH1())) {
                    c1.explota();
                    poum.add(c1);
                    corazonIn.remove(c1);
                    balasOut.add(balasIn.get(y));
                    balasIn.remove(y);
                    balasOut.get(balasOut.size() - 1).reset();
                    
                }
            }
        }
        for(int x=0;x<poum.size();x++)
        {   
            Corazones h1=poum.get(x);
            h1.getDir().update(i);
            if(h1.getDir().getFrame()==3)
            {
                h1.salir();
                corazonOut.add(h1);
                poum.remove(h1);
            }
        }
        if (first > 0) {
            if (first % 2 == 0) {
                mapa = new TiledMap("Mapas\\mapa6.tmx", "\\Construccion Mapas\\");
            } else {
                mapa = new TiledMap("Mapas\\boos3.tmx", "\\Construccion Mapas\\");
            }
            first--;

        } else {
            if (input.isKeyDown(Input.KEY_ENTER)) {
                gc.exit();
            }

            /*for (int x = 0; x < pelotas.size(); x++) {
             if (pelotas.get(x).getH1().intersects(personaje.getH1()) || pelotas.get(x).getH1().intersects(personaje.getH2())
             || pelotas.get(x).getH1().intersects(personaje.getH3()) || pelotas.get(x).getH1().intersects(personaje.getH4())) {

             personaje.setCoordenadaX(1003);
             personaje.setCoordenadaY(651);
             }
             }*/
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
}
