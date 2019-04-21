/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.Madre;
import Personajes.WanderTipo1;
import Personajes.WanderTipoT;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa casa prota
 */
public class Mapa2 extends MapaT{
    
    private final String  mapa = "\\Mapas\\mapa2.tmx";
    
    private Polygon bordes = new Polygon();
    
    private final float   borde1 []  = new float[]{830,701,712,701,712,674,665,674,665,647,618,647,618,625,607,625,607,701,392,701,392,675,547,675,547,571,394,571,394,483,540,483,540,486,606,486,606,547,620,547,618,472,639,472,639,451,697,451,697,415,392,415,392,322,471,322,471,286,392,286,392,196,449,196,449,110,606,110,606,216,517,216,517,265,522,265,522,322,616,322,616,290,695,290,695,255,616,255,616,121,766,121,766,125,831,125,831,254,744,254,744,290,840,290,840,82,895,82,895,290,959,290,959,320,967,320,967,255,930,255,930,100,1021,100,1021,160,1088,160,1088,100,1119,100,1119,200,1088,200,1088,415,968,415,968,367,958,367,958,415,744,415,744,451,763,451,763,548,797,548,797,595,929,595,929,548,961,548,961,460,1118,460,1118,701,895,701,895,737,830,737};
    private final float   borde2 []  = new float[]{1008,609,1008,536,1075,536,1075,609};
    private final ArrayList<float[]> puntos_bordes;

    private final ArrayList<Polygon> colisiones_bordes;
    
    private final float   salida1[] = new float[]{832,704,891,704,891,707,832,707};
    private final float   salida2[] = new float[]{842,94,892,94,892,92,842,92};
    private final ArrayList<float[]> puntos_salidas;
    private final ArrayList<Polygon> colisiones_salidas;
    
    //HISTORIA
    private final ArrayList<Polygon> salidas_modo2;
    private final ArrayList<Polygon> salidas_modo3;
    
    private int modo=1;
    
    private float   mapas[] = new float[]{ 7, 2};
    private float   coord[] = new float[]{1230,349,710,192};
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>(); 
    private Madre madre = new Madre(400,450,this);
    
    
    public Mapa2() {
        super();
        
        personajes.add(madre);
        
        puntos_bordes     = new ArrayList<>();
        colisiones_bordes = new ArrayList<>();
        
        puntos_bordes.add(borde1);
        puntos_bordes.add(borde2);
        
        for(int i=0;i<puntos_bordes.size();i++)
        {
            bordes = new Polygon(puntos_bordes.get(i));
            colisiones_bordes.add(bordes);
        }
        
        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();
        
        salidas_modo2      = new ArrayList<>();
        salidas_modo3      = new ArrayList<>();
        
        puntos_salidas.add(salida1);
        puntos_salidas.add(salida2);
        
        for(int i=0;i<puntos_salidas.size();i++)
        {
            bordes = new Polygon(puntos_salidas.get(i));
            colisiones_salidas.add(bordes);
            if(i==1)
            {
                salidas_modo3.add(bordes);
            }
        }
    }
    
    public void setCoordX(int x,int y)
    {
        if(2*x!=0 && 2*x!=2)
            coord[2*x]=y;
    }
    
    public void setCoordY(int x,int y)
    {
        if((2*x)+1!=1 && (2*x)+1!=3)
            coord[(2*x)+1]=y;
    }
    
    public float[] getCoord() {
        if(modo==2){
            float[] salida = new float[2];
            salida[0]=coord[2];
            salida[1]=coord[3];
            return salida;
        }
        else
            return coord;
    }
      
    public ArrayList<Polygon> getBordes() {
        return colisiones_bordes;
    }

    @Override
    public ArrayList<Polygon> getSalidas() {
        if(modo==1)
            return salidas_modo2;
        if(modo==2)
            return salidas_modo3;
        else
            return colisiones_salidas;
    }
    
    public ArrayList<WanderTipoT> getPersonajes() {
        return personajes;
    }
    
    public void cMode1()
    {
        if(modo==1)
        {
            modo=2;
        } 
    }
    
    public void cMode2()
    {
        if(modo==2)
        {
            modo=3;
        } 
    }
    
    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        if(modo==2)
            return mapas[1];
        else
            return mapas[salida];
    }
}
