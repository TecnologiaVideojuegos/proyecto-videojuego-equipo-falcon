/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa plaza abajo
 */
public class Mapa5 extends MapaT{
    
    private String  mapa = "mapa5.tmx";
    
    private float   puntos1 []  = new float[]{1403,165,1407,254,1249,257,1247,350,1121,351,1121,449,1246,450,1247,544,1404,546,1408,639,1248,640,1247,767,966,767,966,126,460,126,460,163,506,163,506,347,350,347,350,414,322,414,322,598,350,598,350,612,383,612,383,644,412,644,412,611,480,611,480,642,512,642,512,736,255,736,255,800,63,800,64,736,0,736,0,162,406,163,406,127,0,127,0,0,95,0,95,32,352,32,352,64,384,64,384,0,479,0,479,64,512,64,512,32,703,32,703,0,1245,0,1245,165};
    private float   puntos2 []  = new float[]{132,660,90,660,90,641,132,641};
    private float   puntos3 []  = new float[]{0,0,0,0,0,0,0,00};
    private float   puntos4 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos5 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos6 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos7 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos8 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos9 []  = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon bordes [] = new Polygon[9];
    
    private float   puntos21[] = new float[]{426,612,471,612,471,613,426,613};
    private float   puntos22[] = new float[]{390,0,474,0,474,2,390,2};
    private float   puntos23[] = new float[]{66,798,252,798,252,800,66,800};
    private float   puntos24[] = new float[]{776,2,1241,2,1241,0,776,0};
    
    private Polygon salidas[] = new Polygon[4];
    //colegio - plaza central - boss1 - plaza centrak
    private float   mapas[] = new float[]{6,0,5,0};
    private float   coord[] = new float[]{0,0,400,700,0,0,0,720};
    
    public Mapa5() {
        super();
        bordes[0]  = new Polygon(puntos1);
        bordes[1]  = new Polygon(puntos2);
        bordes[2]  = new Polygon(puntos3);
        bordes[3]  = new Polygon(puntos4);
        bordes[4]  = new Polygon(puntos5);
        bordes[5]  = new Polygon(puntos6);
        bordes[6]  = new Polygon(puntos7);
        bordes[7]  = new Polygon(puntos8);
        bordes[8]  = new Polygon(puntos9);
        
        salidas[0] = new Polygon(puntos21);
        salidas[1] = new Polygon(puntos22);
        salidas[2] = new Polygon(puntos23);
        salidas[3] = new Polygon(puntos24);
    }
    
      public void setCoordX(int x,int y)
    {
        coord[2*x]=y;
    }
    
    public void setCoordY(int x,int y)
    {
        coord[(2*x)+1]=y;
    }
    
    public Polygon[] getBordes() {
        return bordes;
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
