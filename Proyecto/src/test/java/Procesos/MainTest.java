package Procesos;

import Classes.Torneo;
import org.junit.Before;
import static Procesos.Main.ListaPartidos;
import static Procesos.Main.ListaJugadores;
import static org.junit.Assert.*;

public class MainTest {

    Torneo T;
    PronosticosResultado Juego;

    @Before
    public void crearTorneo(){
        T  = new Torneo(ListaPartidos("../Proyecto/src/test/resources/testPartidosMain.csv"));
        assertTrue("Chequear que haya datos", T.obtenerResultados().isEmpty());
    }

    @Before
    public void crearPronostico(){
        Juego = new PronosticosResultado(T,ListaJugadores("../Proyecto/src/test/resources/testPronosticosMain.csv"));
       assertTrue("Chequear que haya datos", Juego.getJugadores().isEmpty());
    }

}