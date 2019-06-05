/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import EstadoBoss1.Boss1;
import EstadoBoss2.Boss2;
import EstadoBoss3.Boss3;
import Estados.Boss4;
import Estados.BuhardillaInicial;
import Estados.CasaInicial;
import Estados.Cinematica0;
import Estados.Cinematica1;
import Estados.Cinematica2;
import Estados.Cinematica3;
import Estados.Cinematica4;
import Estados.Cinematica5;
import Estados.CinematicaInicial;
import Estados.CinematicaPostBuhardilla;
import Estados.CinematicaPostCasa;
import Estados.CinematicaPostColegio;
import Estados.CinematicaPostCompra;
import Estados.CinematicaPostFin;
import Estados.CinematicaPostPlaya;
import Estados.ColegioInicial;
import Estados.CompraFinal;
import Estados.CompraInicial;
import Estados.FIN1;
import Estados.FIN2;
import Estados.Instrucciones0;
import Estados.Menu;
import Estados.Menu2;
import Estados.Mundo;
import Estados.PatioInicial;
import Estados.PlayaFinal;
import Estados.PlayaInicial;
import Multijuegos.Boss1M;
import Multijuegos.Boss2M;
import Multijuegos.Boss3M;
import Multijuegos.Boss4M;
import Multijuegos.InstruccionesMinis0;
import Multijuegos.InstruccionesMinis1;
import Multijuegos.InstruccionesMinis2;
import Multijuegos.InstruccionesMinis3;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author lucas
 */
public class Juego extends StateBasedGame {

    private AppGameContainer contenedor;
    public Juego(String name) {
        super(name);
        try {
            contenedor = new AppGameContainer(this);
            contenedor.setTargetFrameRate(400);
            contenedor.setDisplayMode(1504, 800,false);
            contenedor.start();
        } catch (SlickException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {

        this.addState(new Menu());
        this.addState(new Menu2());

        this.addState(new Instrucciones0());
        this.addState(new CinematicaInicial());

        this.addState(new Boss1M());
        this.addState(new InstruccionesMinis0());
        this.addState(new Boss2M());
        this.addState(new InstruccionesMinis1());
        this.addState(new Boss3M());
        this.addState(new InstruccionesMinis2());
        this.addState(new Boss4M());
        this.addState(new InstruccionesMinis3());

        this.addState(new CasaInicial());
        this.addState(new BuhardillaInicial());
        this.addState(new Cinematica0());
        this.addState(new CinematicaPostBuhardilla());

        this.addState(new PlayaInicial());
        this.addState(new Cinematica1());
        this.addState(new Boss1());
        this.addState(new PlayaFinal());
        this.addState(new CinematicaPostPlaya());

        this.addState(new ColegioInicial());
        this.addState(new CinematicaPostColegio());
        this.addState(new PatioInicial());
        this.addState(new Cinematica2());
        this.addState(new Boss2());

        this.addState(new CinematicaPostCasa());
        this.addState(new CompraInicial());
        this.addState(new Cinematica3());
        this.addState(new Boss3());
        this.addState(new Cinematica4());
        this.addState(new CompraFinal());
        this.addState(new CinematicaPostCompra());

        this.addState(new FIN1());
        this.addState(new Cinematica5());
        this.addState(new Boss4());
        this.addState(new FIN2());
        this.addState(new CinematicaPostFin());

        this.addState(new Mundo(1));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego juego = new Juego("Alex's Legacy");
 
    }

}
