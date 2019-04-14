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
 * @mapa carretera central
 * 
 */
public class Mapa9 extends MapaT{
    
    private String  mapa = "\\Mapas\\mapa9.tmx";
    
    private float   puntos1 []  = new float[]{1504,36,1504,800,865,800,865,94,1056,94,1056,36};
    private float   puntos2 []  = new float[]{640,800,257,800,257,763,30,763,30,451,98,451,98,480,126,480,126,448,192,448,192,480,222,480,222,448,
335,448,335,382,415,382,415,354,451,354,451,318,416,318,416,286,559,286,559,35,640,35};
    private float   puntos3 []  = new float[]{1342,640,993,640,993,352,1342,352};
    private float   puntos4 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos5 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos6 []  = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon bordes = new Polygon();
    private ArrayList<Polygon> colisiones;
    private ArrayList<float[]> puntos;
    
    private float   puntos22[] = new float[]{258,797,1500,797,1500,798,258,798};
    private float   puntos23[] = new float[]{1503,204,1503,800,1502,800,1502,204};
    private ArrayList<Polygon> salidas;
    private ArrayList<float[]> extremos;
    //carretera central - plaza arriba
    private float   mapas[] = new float[]{7,3};
    private float   coord[] = new float[]{0,0,0,0};

    public Mapa9() {
        super();
        puntos     = new ArrayList<>();
        colisiones = new ArrayList<>();
        
        puntos.add(puntos1);
        puntos.add(puntos2);
        puntos.add(puntos3);
        puntos.add(puntos4);
        puntos.add(puntos5);
        puntos.add(puntos6);
        
        for(int i=0;i<puntos.size();i++)
        {
            bordes = new Polygon(puntos.get(i));
            colisiones.add(bordes);
        }
        
        
        extremos  = new ArrayList<>();
        salidas   = new ArrayList<>();
        
   
        extremos.add(puntos22);
        extremos.add(puntos23);
        
        for(int i=0;i<extremos.size();i++)
        {
            bordes = new Polygon(extremos.get(i));
            salidas.add(bordes);
        }
    }
    
      public void setCoordX(int x,int y)
    {
        coord[2*x]=y;
    }
    
    public void setCoordY(int x,int y)
    {
        coord[(2*x)+1]=y;
    }
      
    public ArrayList<Polygon> getBordes() {
        return colisiones;
    }

    public ArrayList<Polygon> getSalidas() {
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
