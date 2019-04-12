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
 * @mapa plaza central
 */
public class Mapa1 extends MapaT{
    
    private String  mapa = "\\mapa1.tmx";
    
    private float   puntos1 []  = new float[]{0,800,383,800,383,769,383,737,319,737,255,737,255,705,223,705,191,705,191,673,159,673,159,641,127,641,127,609,127,577,95,577,95,545,95,513,95,449,63,449,31,449,0,449,0,351,31,351,63,351,95,351,95,289,95,225,127,225,127,193,127,161,159,161,159,129,191,129,191,97,223,97,255,97,255,65,287,65,319,65,351,65,383,65,383,0,0,0};
    private float   puntos2 []  = new float[]{479,0,479,64,607,64,607,96,671,96,671,128,703,128,703,160,735,160,735,224,767,224,767,352,799,352,799,320,863,320,863,160,1151,160,1183,192,1247,192,1247,160,1407,160,1407,256,1247,256,1247,352,1119,352,1119,448,1247,448,1247,544,1407,544,1407,640,1247,640,1247,800,768,800,768,768,768,736,800,736,800,704,832,704,832,639,864,639,864,478,800,478,800,447,768,447,768,575,736,575,736,639,704,639,704,671,672,671,672,703,608,703,608,735,480,735,480,800,1504,800,1504,0};
    private float   puntos3 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos4 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos5 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos6 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos7 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos8 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos9 []  = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon bordes [] = new Polygon[20];
    
    private float   puntos21[] = new float[]{390,0,474,0,474,2,390,2};
    private float   puntos22[] = new float[]{390,800,474,800,474,798,390,798};
    private float   puntos23[] = new float[]{0,353,0,445,2,445,2,353};
    private float   puntos24[] = new float[]{776,798,1241,798,1241,800,776,800};
    
    private Polygon salidas[] = new Polygon[4];
    //plaza arriba - plaza abajo - plaza izquierda - plaza abajo
    private float   mapas[] = new float[]{3,4,7,4};
    
    private float   coord[] = new float[]{0,720,0,0,1438,0,0,0};
    
    
    public Mapa1() {
        super();
        bordes [0] = new Polygon(puntos1);
        bordes [1] = new Polygon(puntos2);
        bordes [2] = new Polygon(puntos3);
        bordes [3] = new Polygon(puntos4);
        bordes [4] = new Polygon(puntos5);
        bordes [5] = new Polygon(puntos6);
        bordes [6] = new Polygon(puntos7);
        bordes [7] = new Polygon(puntos8);
        bordes [8] = new Polygon(puntos9);
        
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
