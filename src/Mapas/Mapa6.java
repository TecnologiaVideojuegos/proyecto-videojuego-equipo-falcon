/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.ProfEd;
import Personajes.WanderTipoT;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa zona boss 1
 */
public class Mapa6 extends MapaT {

    private String mapa = "\\Mapas\\mapa6.tmx";
    
    private Polygon bordes = new Polygon();
    
    private float borde1[] = new float[]{63, 0, 256, 0, 256, 33, 985, 33, 985, 65, 1027, 65, 1027, 36, 1180, 36, 1180, 68, 1218, 68, 1218, 141, 1242, 164, 1242, 200, 1282, 200, 1282, 186, 1402, 186, 1433, 223, 1469, 223, 1469, 778, 1091, 778, 1091, 741, 1184, 738, 1184, 671, 1153, 671, 1153, 700, 1058, 700, 1058, 733, 1020, 733, 1020, 785, 35, 785, 35, 32, 65, 32};
    private ArrayList<float[]> colisiones_bordes;
    private ArrayList<Polygon> colisiones;

    private float salida1[] = new float[]{66, 2, 252, 2, 252, 0, 66, 0};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;
    
    ProfEd profesor = new ProfEd();

    //plaza abajo
    private float mapas[] = new float[]{4};
    private float coord[] = new float[]{0, 720};
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>(); 
    
    
    public Mapa6() {
        super();
        colisiones_bordes = new ArrayList<>();
        colisiones        = new ArrayList<>();

        colisiones_bordes.add(borde1);

        for (int i = 0; i < colisiones_bordes.size(); i++) {
            bordes = new Polygon(colisiones_bordes.get(i));
            colisiones.add(bordes);
        }

        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();

        puntos_salidas.add(salida1);

        for (int i = 0; i < puntos_salidas.size(); i++) {
            bordes = new Polygon(puntos_salidas.get(i));
            colisiones_salidas.add(bordes);
        }
        profesor.noLanza();
        personajes.add(profesor);
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
        return colisiones;
    }

    public ArrayList<Polygon> getSalidas() {
        return colisiones_salidas;
    }

    public ArrayList<WanderTipoT> getPersonajes() {
        return personajes;
    }
    
    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        return mapas[salida];
    }
}
