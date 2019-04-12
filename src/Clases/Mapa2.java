/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa casa prota
 */
public class Mapa2 extends MapaT{
    
    private String  mapa = "\\mapa2.tmx";
    
    private float   puntos1 []  = new float[]{830,701,712,701,712,674,665,674,665,647,618,647,618,625,607,625,607,701,392,701,392,675,547,675,547,571,394,571,394,483,540,483,540,486,606,486,606,547,620,547,618,472,639,472,639,451,697,451,697,415,392,415,392,322,471,322,471,286,392,286,392,196,449,196,449,110,606,110,606,216,517,216,517,265,522,265,522,322,616,322,616,290,695,290,695,255,616,255,616,121,766,121,766,125,831,125,831,254,744,254,744,290,840,290,840,82,895,82,895,290,959,290,959,320,967,320,967,255,930,255,930,100,1021,100,1021,160,1088,160,1088,100,1119,100,1119,200,1088,200,1088,415,968,415,968,367,958,367,958,415,744,415,744,451,763,451,763,548,797,548,797,595,929,595,929,548,961,548,961,460,1118,460,1118,701,895,701,895,737,830,737};
    private float   puntos2 []  = new float[]{1008,609,1008,536,1075,536,1075,609};
    
    private Polygon bordes = new Polygon();
    private ArrayList<Polygon> colisiones;
    private ArrayList<float[]> puntos;
    
    private float   puntos21[] = new float[]{832,704,891,704,891,707,832,707};
    private float   puntos22[] = new float[]{842,94,892,94,892,92,842,92};
    private float   puntos23[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos24[] = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon salidas[] = new Polygon[4];
    
    private float   mapas[] = new float[]{7,2,0,0};
    private float   coord[] = new float[]{1230,349,710,192,0,0,0,0,0,0};
    
    public Mapa2() {
        super();
        puntos     = new ArrayList<>();
        colisiones = new ArrayList<>();
        
        puntos.add(puntos1);
        puntos.add(puntos2);
        
        for(int i=0;i<puntos.size();i++)
        {
            bordes = new Polygon(puntos.get(i));
            colisiones.add(bordes);
        }
        
        
        salidas[0] = new Polygon(puntos21);
        salidas[1] = new Polygon(puntos22);
        salidas[2] = new Polygon(puntos23);
        salidas[3] = new Polygon(puntos24);
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
      
    public ArrayList<Polygon> getBordes() {
        return colisiones;
    }

    public Polygon[] getSalidas() {
        return salidas;
    }

    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        return mapas[salida];
    }
    
    public float[] getCoord() {
        return coord;
    }
    
}
