/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.PersonajeGeneral;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 */
public class MapaT {

    private String mapa = "\\Mapas\\mapa2.tmx";

    private Polygon bordes = new Polygon();
    
    private ArrayList<Polygon> colisiones_bordes;
    private ArrayList<Polygon> colisiones_salidas;

    private float mapas[] = new float[]{0, 1, 2, 3};
    private float coord[] = new float[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private ArrayList<PersonajeGeneral> personajes = new ArrayList<>(); 
    private int modo=0;
    
    public MapaT() {
    }

    public void setCoordX(int x, int y) {
        coord[2 * x] = y;
    }

    public void setCoordY(int x, int y) {
        coord[(2 * x) + 1] = y;
    }

    
    public float[] getCoord() {
        return coord;
    }
    
    public ArrayList<Polygon> getBordes() {
        return colisiones_bordes;
    }

    public ArrayList<Polygon> getSalidas() {
        return colisiones_salidas;
    }

    public ArrayList<PersonajeGeneral> getPersonajes() {
        return personajes;
    }
    
        
    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        return mapas[salida];
    }
    
    public void chMod()
    {
        modo=1;
    }
}
