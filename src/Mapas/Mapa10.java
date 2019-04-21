/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.WanderTipoT;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa carretera abajo
 */
public class Mapa10 extends MapaT {

    private String mapa = "\\Mapas\\mapa10.tmx";
    
    private Polygon bordes = new Polygon();
    
    private float borde1[] = new float[]{32,1,1501,1,1501,128,1263,128,1263,160,1501,160,1501,736,1216,736,1216,707,1190,707,1190,674,1156,674,1156,702,1117,702,1117,738,549,738,549,609,669,609,669,572,788,572,788,544,552,544,552,159,1099,159,1099,545,874,545,874,574,960,574,960,608,1054,608,1054,573,1109,573,1109,159,1202,159,1202,128,544,128,544,669,434,669,434,647,399,647,399,667,307,667,307,647,266,647,266,666,173,666,173,647,132,647,132,666,32,666};
    private float borde2[] = new float[]{615,223,615,313,730,313,730,223};
    private float borde3[] = new float[]{773,315,888,315,888,223,773,223};
    private float borde4[] = new float[]{935,313,1048,313,1048,223,935,223};
    private float borde5[] = new float[]{672,703,764,703,764,675,672,675};
    private float borde6[] = new float[]{1249,578,1341,578,1341,547,1249,547};
    private float borde7[] = new float[]{480,225,415,225,415,193,480,193};
    private float borde8[] = new float[]{480,322,415,322,415,290,480,290};
    private float borde9[] = new float[]{480,419,415,419,415,387,480,387};
    private float borde10[] = new float[]{480,516,415,516,415,484,480,484};
    private float borde11[] = new float[]{160,225,95,225,95,193,160,193};
    private float borde12[] = new float[]{160,322,95,322,95,290,160,290};
    private float borde13[] = new float[]{160,419,95,419,95,387,160,387};
    private float borde14[] = new float[]{160,516,95,516,95,484,160,484};
    private float borde15[] = new float[]{373,515,373,485,363,485,363,515};
    private float borde16[] = new float[]{217,515,217,485,205,485,205,515};
    private ArrayList<float[]> colisiones_bordes;
    private ArrayList<Polygon> colisiones;
    
    private float salida1[] = new float[]{32,2,1501,2,1501,1,32,1};
    private float salida2[] = new float[]{1501,161,1501,736,1500,736,1599,161};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;
    
    //carretera central - plaza abajo
    private float mapas[] = new float[]{7, 4};
    private float coord[] = new float[]{89, 703, 0, 0};
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>();
    
    
    public Mapa10() {
        super();
        
        colisiones_bordes = new ArrayList<>();
        colisiones        = new ArrayList<>();

        colisiones_bordes.add(borde1);
        colisiones_bordes.add(borde2);
        colisiones_bordes.add(borde3);
        colisiones_bordes.add(borde4);
        colisiones_bordes.add(borde5);
        colisiones_bordes.add(borde6);
        colisiones_bordes.add(borde7);
        colisiones_bordes.add(borde8);
        colisiones_bordes.add(borde9);
        colisiones_bordes.add(borde10);
        colisiones_bordes.add(borde11);
        colisiones_bordes.add(borde12);
        colisiones_bordes.add(borde13);
        colisiones_bordes.add(borde14);
        colisiones_bordes.add(borde15);
        colisiones_bordes.add(borde16);

        for (int i = 0; i < colisiones_bordes.size(); i++) {
            bordes = new Polygon(colisiones_bordes.get(i));
            colisiones.add(bordes);
        }

        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();

        puntos_salidas.add(salida1);
        puntos_salidas.add(salida2);

        for (int i = 0; i < puntos_salidas.size(); i++) {
            bordes = new Polygon(puntos_salidas.get(i));
            colisiones_salidas.add(bordes);
        }
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
