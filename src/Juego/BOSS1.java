/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Clases.Sprite;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class BOSS1 extends BasicGameState{
    
    
    private String  mapa1 = "C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\boos1D.tmx";
    private float   puntos1 []  = new float[]{63,0,256,0,256,33,985,33,985,65,1027,65,1027,36,1180,36,1180,68,1218,68,1218,141,1242,164,1242,200,1282,200,1282,186,1402,186,1433,223,1469,223,1469,778,1091,778,1091,741,1184,738,1184,671,1153,671,1153,700,1058,700,1058,733,1020,733,1020,785,35,785,35,32,65,32};
    private Polygon bordes;
    int first=5;
    int a = 0, b = 0, c = 0, d = 0;
    TiledMap mapa;
    Sprite personaje;
    
    public BOSS1() {
        bordes = new Polygon(puntos1);
    }
    
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap(mapa1);
        personaje = new Sprite();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);
        
        
        for(int i=0;i<20;i++)
        {
          g.draw(bordes);  
        }
        
        
        
     
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if(first>0)
        {
            if(first%2==0)
                mapa = new TiledMap("C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\mapa6.tmx");
            else
                mapa = new TiledMap("C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\boos1D.tmx");
            
            for(int x=0;i<10000;i++){}
            first--;
        }else
        {
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_ENTER)) {
            gc.exit();
        }
        
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
        {
            System.out.println(input.getMouseX() + "," + input.getMouseY() + ",");
        }
        //System.out.println();
        if (input.isKeyDown(Input.KEY_W)) {
            personaje.setDir("up");
            personaje.getDir().update(i);
            for(int n=0;n<20;n++)
            {
                if (personaje.getH1().intersects(bordes)) {
                    a = 1;
                    break;
                } else {
                    a = 0;
                } 
            }
            if (a == 0 || b == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f);
                b = 0;
            }

        } else if (input.isKeyDown(Input.KEY_S)) {
            personaje.setDir("down");
            personaje.getDir().update(i);
            for(int n=0;n<20;n++)
            {
                if (personaje.getH4().intersects(bordes)) {
                    b = 1;
                    break;
                } else {
                    b = 0;
                } 
            }
            if (b == 0 || a == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f);
                a = 0;
            }

        } else if (input.isKeyDown(Input.KEY_A)) {
            personaje.setDir("left");
            personaje.getDir().update(i);
            for(int n=0;n<20;n++)
            {
                if (personaje.getH2().intersects(bordes)) {
                    c = 1;
                    break;
                } else {
                    c = 0;
                } 
            }
            if (c == 0 || d == 1) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f);
                d = 0;
            }

        } else if (input.isKeyDown(Input.KEY_D)) {
            personaje.setDir("right");
            personaje.getDir().update(i);
            for(int n=0;n<20;n++)
            {
                if (personaje.getH3().intersects(bordes)) {
                    d = 1;
                    break;
                } else {
                    d = 0;
                } 
            }
            
            if (d == 0 || c == 1) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f);
                c = 0;

            }

        } else {
            personaje.setDir("stance");
            personaje.getDir().update(i);
        }
  
    }
    }
}
