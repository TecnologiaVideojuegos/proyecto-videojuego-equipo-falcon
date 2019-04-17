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
    ArrayList<Corazones> corazon;
    ArrayList<Arresto> balas;
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
        corazon = new ArrayList<>();
        balas = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            heart = new Corazones();
            corazon.add(heart);
        }
        for (int i = 0; i < 100; i++) {
            bala = new Arresto();
            balas.add(bala);
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        for (int i = 0; i < corazon.size(); i++) {
            corazon.get(i).getDir().draw(corazon.get(i).getCoordenadaX(), corazon.get(i).getCoordenadaY());
            g.draw(corazon.get(i).getH1());
        }
        for (int i = 0; i < balas.size(); i++) {
            if (balas.get(i).getEstado() == 1) {
                balas.get(i).getImage().draw(balas.get(i).getCoordenadaX(), balas.get(i).getCoordenadaY());

            }
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
        if (fase % 50 == 0 && fase / 50 < corazon.size()) {
            corazon.get((fase / 50) - 1).init();
        }
        if (input.isKeyDown(Input.KEY_SPACE) && fase % 50 == 0) {
            balas.get(num).init(personaje.getCoordenadaX() + 30, personaje.getCoordenadaY() + 15);
            num++;
            if (num >= balas.size()) {
                num = 0;
            }
        }
        for (int x = 0; x < balas.size(); x++) {
            if (balas.get(x).getEstado() == 1) {
                balas.get(x).move();
            }
        }
        for (int x = 0; x < corazon.size(); x++) {
            if (corazon.get(x).getEstado() == 1) {
                corazon.get(x).move();
            }

            if (corazon.get(x).getCoordenadaX() <= 200) {

                if (corazon.get(x).getDir().getFrameCount() == 2) {
                    corazon.get(x).explota();
                }
                corazon.get(x).getDir().update(i);
                if (corazon.get(x).getDir().getFrame() == 3) {
                    corazon.get(x).salir();
                }
            }

        }
        if (fase / 50 >= corazon.size()) {
            fase = 0;
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
