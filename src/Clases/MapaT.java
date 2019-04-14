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
 */
public class MapaT {
        
    private String  mapa = "\\Mapas\\mapa2.tmx";
    
    private Polygon bordes = new Polygon();
    private ArrayList<Polygon> colisiones;
    private ArrayList<float[]> puntos;
    
    private float   puntos21[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos22[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos23[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos24[] = new float[]{0,0,0,0,0,0,0,0}; 
    private ArrayList<Polygon> salidas;
    private ArrayList<float[]> extremos;
    
    private float   mapas[] = new float[]{0,1,2,3};
    private float   coord[] = new float[]{0,0,0,0,0,0,0,0,0,0};
    
    public MapaT() {        
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
