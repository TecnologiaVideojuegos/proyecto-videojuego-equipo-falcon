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
 * @mapa buhardilla
 */
public class Mapa3 extends MapaT{
    
    private String  mapa = "\\mapa3.tmx";
    
    private float   puntos1 []  = new float[]{705,192,838,192,838,220,865,220,865,255,935,255,935,277,963,277,963,321,991,321,991,377,961,377,961,446,931,446,931,471,957,471,957,480,989,480,989,512,902,512,902,564,867,564,867,572,512,572,512,289,540,289,540,250,700,250,700,388,737,388,737,413,767,413,767,388,799,388,799,366,771,366,771,257,768,257,768,381,705,381};
    private float   puntos2 []  = new float[]{1008,609,1008,536,1075,536,1075,609};
    private float   puntos3 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos4 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos5 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos6 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos7 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos8 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos9 []  = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon bordes [] = new Polygon[9];
    
    private float   puntos21[] = new float[]{832,704,891,704,891,707,832,707};
    private float   puntos22[] = new float[]{842,94,892,94,892,92,842,92};
    private float   puntos23[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos24[] = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon salidas[] = new Polygon[4];
    
    private float   mapas[] = new float[]{0,3,2,3};
    private float   coord[] = new float[]{0,0,0,0,0,0,0,0,0,0};
    
    public Mapa3() {
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
