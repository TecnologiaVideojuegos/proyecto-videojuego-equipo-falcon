/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Pelota;
import Personajes.MainChar;
import Personajes.ProfEd;
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
public class Boss1 extends BasicGameState{
    
    
    private String  mapa1 = "Mapas\\boos1D.tmx";
    private float   puntos1 []  = new float[]{1120,716,127,716,127,683,223,683,223,589,127,589,127,556,830,556,830,462,127,462,127,429,575,429,575,333,127,333,127,300,255,300,255,204,127,204,127,171,1120,171,1120,204,300,204,300,300,864,300,864,333,618,333,618,429,1120,429,1120,462,875,462,875,556,1120,556,1120,589,267,589,267,683,1120,683};
    private Polygon bordes;
    int first=10;
    int mapaMov=0;
    int a = 0, b = 0, c = 0, d = 0;
    TiledMap mapa;
    MainChar personaje;
    ProfEd p1;
    ArrayList<Pelota> pelotas = new ArrayList<>();
    Pelota ball;
    public Boss1() {
        bordes = new Polygon(puntos1);
        for(int i=0;i<10;i++)
        {
            ball= new Pelota();
            pelotas.add(ball);
        }
    }
    
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap(mapa1,"\\Construccion Mapas\\");
        personaje = new MainChar();
        p1 = new ProfEd();
        personaje.setCoordenadaX(703);
        personaje.setCoordenadaY(651);
        ball = new Pelota();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        p1.getDir().draw(954,270);
        ball.getDir().draw(ball.getCoordenadaX(), ball.getCoordenadaY());
        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);
        
        
        
        g.draw(personaje.getH1());
        g.draw(personaje.getH2());
        g.draw(personaje.getH3());
        g.draw(personaje.getH4());
        
        for(int i=0;i<20;i++)
        {
          g.draw(bordes);  
        }
        
        
        
     
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        Input input = gc.getInput();
        p1.getDir().update(i);
        if(ball.getDir().getFrameCount()==3 && ball.getDir().getFrame()==2)
        {
            ball.setDir("gira");
            ball.setDestino(personaje.getCoordenadaX()-16,personaje.getCoordenadaY()-16);
        }
        else if(p1.getDir().getFrame()==5)
        {
            ball.getDir().update(i);
        }
        if(ball.getDir().getFrameCount()==4 )
        {
            ball.move();
            ball.getDir().update(i);
        }
        
        if(!input.isKeyDown(Input.KEY_0)&&first>0)
        {
            if(first%2==0){
                mapa = new TiledMap("Mapas\\mapa6.tmx","\\Construccion Mapas\\");
            }
                else{
                mapa = new TiledMap("Mapas\\boos1D.tmx","\\Construccion Mapas\\");}
                first--;
            
            
        }else
        {
            
        //prueba fuego    
        /*if(first%100==0){
                mapa = new TiledMap("C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\boos1V.tmx");
            }
        else if(first%30==0){
                mapa = new TiledMap("C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\boos1D.tmx");}
                first--;    */
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
            personaje.setDir("up");
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
