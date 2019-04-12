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
 * @mapa zona boss 1
 */
public class Mapa6 extends MapaT{
    
    private String  mapa = "\\mapa6.tmx";
    
    private float   puntos1 []  = new float[]{63,0,256,0,256,33,985,33,985,65,1027,65,1027,36,1180,36,1180,68,1218,68,1218,141,1242,164,1242,200,1282,200,1282,186,1402,186,1433,223,1469,223,1469,778,1091,778,1091,741,1184,738,1184,671,1153,671,1153,700,1058,700,1058,733,1020,733,1020,785,35,785,35,32,65,32};
        
    private Polygon bordes = new Polygon();
    private ArrayList<Polygon> colisiones;
    private ArrayList<float[]> puntos;
    
    private float   puntos21[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos22[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos23[] = new float[]{66,2,252,2,252,0,66,0};
    private float   puntos24[] = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon salidas[] = new Polygon[4];
    
    private float   mapas[] = new float[]{0,1,4,3};
    //plaza abajo
    private float   coord[] = new float[]{0,0,0,0,0,720,0,0};
    
    public Mapa6() {
        super();
        puntos     = new ArrayList<>();
        colisiones = new ArrayList<>();
        
        puntos.add(puntos1);
        
        for(int i=0;i<puntos.size();i++)
        {
            bordes = new Polygon(puntos.get(i));
            colisiones.add(bordes);
        }
        
        
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
    
    public ArrayList<Polygon> getBordes() {
        return colisiones;
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
