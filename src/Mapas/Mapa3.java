/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.Atari;
import Personajes.WanderTipoT;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa buhardilla
 */
public class Mapa3 extends MapaT {

    private String mapa = "\\Mapas\\mapa3.tmx";
    
    private Polygon bordes = new Polygon();
    
    private float borde1[] = new float[]{705, 192, 838, 192, 838, 220, 865, 220, 865, 255, 935, 255, 935, 277, 963, 277, 963, 321, 991, 321, 991, 377, 961, 377, 961, 446, 931, 446, 931, 471, 957, 471, 957, 480, 989, 480, 989, 512, 902, 512, 902, 564, 867, 564, 867, 572, 512, 572, 512, 289, 540, 289, 540, 250, 700, 250, 700, 388, 737, 388, 737, 413, 767, 413, 767, 388, 799, 388, 799, 366, 771, 366, 771, 257, 768, 257, 768, 381, 705, 381};
    private float borde2[] = new float[]{862, 482, 898, 482, 898, 449, 862, 449};
    private float borde3[] = new float[]{605, 322, 578, 322, 578, 290, 605, 290};
    private float borde4[] = new float[]{870, 353, 891, 353, 891, 320, 870, 320};
    private float borde5[] = new float[]{740, 544, 802, 544, 802, 510, 740, 510};
    //private float borde6[] = new float[]{606, 450, 642, 450, 642, 415, 606, 415};
    private ArrayList<float[]> puntos_bordes;
    private ArrayList<Polygon> colisiones_bordes;

    private float salida1[] = new float[]{707, 355, 763, 355, 763, 354, 707, 354};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;
    
    private float mapas[] = new float[]{1};
    private float coord[] = new float[]{840, 90};
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>(); 
    private Atari atari;

    public Mapa3(Mapa2 mapa2) {
        super();
        
        atari=new Atari(608,384,mapa2);
        personajes.add(atari);
        
        puntos_bordes     = new ArrayList<>();
        colisiones_bordes = new ArrayList<>();

        puntos_bordes.add(borde1);
        puntos_bordes.add(borde2);
        puntos_bordes.add(borde3);
        puntos_bordes.add(borde4);
        puntos_bordes.add(borde5);
        //puntos_bordes.add(borde6);

        for (int i = 0; i < puntos_bordes.size(); i++) {
            bordes = new Polygon(puntos_bordes.get(i));
            colisiones_bordes.add(bordes);
        }

        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();

        puntos_salidas.add(salida1);

        for (int i = 0; i < puntos_salidas.size(); i++) {
            bordes = new Polygon(puntos_salidas.get(i));
            colisiones_salidas.add(bordes);
        }
    }

    public void setCoordX(int x, int y) {
        if (2 * x != 0) {
            coord[2 * x] = y;
        }
    }

    public void setCoordY(int x, int y) {
        if ((2 * x) + 1 != 1) {
            coord[(2 * x) + 1] = y;
        }
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
