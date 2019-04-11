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
 * @mapa plaza arriba
 */
public class Mapa4 extends MapaT{
    
    private String  mapa = "mapa4.tmx";
    
    private float   puntos1 []  = new float[]{384,735,64,736,63,767,31,769,31,799,0,799,0,201,842,201,840,287,1182,287,1183,158,1244,159,1245,165,1403,165,1407,254,1249,257,1247,350,1121,351,1121,449,1246,450,1247,544,1404,546,1408,639,1248,640,1247,767,551,767,550,737,480,737,480,798,384,798,384,737};
    private float   puntos2 []  = new float[]{95,397,192,397,192,266,95,266};
    private float   puntos3 []  = new float[]{95,591,191,591,191,460,95,460};
    private float   puntos4 []  = new float[]{255,266,255,400,352,400,352,266};
    private float   puntos5 []  = new float[]{255,459,255,590,352,590,352,459};
    private float   puntos6 []  = new float[]{510,267,510,399,607,399,607,267};
    private float   puntos7 []  = new float[]{510,459,510,592,608,592,608,459};
    private float   puntos8 []  = new float[]{671,266,671,397,767,397,767,266};
    private float   puntos9 []  = new float[]{671,460,671,590,768,590,768,460};
    
    private Polygon bordes [] = new Polygon[9];
    
    private float   puntos21[] = new float[]{390,800,474,800,474,798,390,798};
    private float   puntos22[] = new float[]{0,204,0,729,2,792,2,204};
    private float   puntos23[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos24[] = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon salidas[] = new Polygon[4];
    //plaza central 
    private float   mapas[] = new float[]{0,7,2,3};
    private float   coord[] = new float[]{0,0,1438,0,0,0,0,0,0,0};
    
    public Mapa4() {
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
