package Classes;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class JugadorTest {

    private Jugador Jugador1,Jugador2;

    public ArrayList<String> crearListadelPornosticoJugador(String local, String visitante, String resultado){
        ArrayList<String> lista = new ArrayList<>();
        lista.add(local);
        lista.add(visitante);
        lista.add(resultado);
        return lista;
    }

    @Before
    public void crearJugadores(){
        Jugador1 = new Jugador("Lucas",crearListadelPornosticoJugador("Suiza","Alemania","Suiza"));
        Jugador2 = new Jugador("Lucio",crearListadelPornosticoJugador("Suiza","Alemania","Alemania"));
    }
    @Test
    public void testCrearJuagador(){
        assertTrue("El Jugador 1 fue creado ",Jugador1 != null);
        assertTrue("El Jugador 2 fue creado ",Jugador2 != null);
    }

    @Test
    public void testObtenerNombre() {
        assertTrue("El nombre del 1er Jugador es Lucas",Jugador1.obtenerNombre().equals("Lucas"));
        assertTrue("El nombre del 2do Jugador es Lucio",Jugador2.obtenerNombre().equals("Lucio"));
    }

    @Test
    public void testObtenerPuntaje() {
        Jugador1.setearPuntaje(5);
        Jugador2.setearPuntaje(6);
        assertEquals("El puntaje del 1er Jugador es correcto",5,Jugador1.obtenerPuntaje());
        assertEquals("El puntaje del 2do Jugador es correcto",6,Jugador2.obtenerPuntaje());

        Jugador1.setearPuntaje(5);
        Jugador2.setearPuntaje(6);
        assertEquals("El puntaje del 1er Jugador es correcto",10,Jugador1.obtenerPuntaje());
        assertEquals("El puntaje del 2do Jugador es correcto",12,Jugador2.obtenerPuntaje());
    }


    @Test
    public void testObtenerPronostico() {
        assertTrue("El pronostico 1er Jugador es Alemania",Jugador1.obtenerPronostico("Suiza-Alemania").equals("Alemania"));
        assertTrue("El pronostico del 2do Jugador es Suiza",Jugador2.obtenerPronostico("Suiza-Alemania").equals("Suiza"));
        assertFalse("El pronostico del 2do Jugador es Alemania",Jugador2.obtenerPronostico("Suiza-Alemania").equals("Suiza"));
    }

    @Test
    public void testCargarPronosticos() {
        Jugador1.cargarPronosticos(crearListadelPornosticoJugador("Argentina","Francia","Argentina"));
        Jugador2.cargarPronosticos(crearListadelPornosticoJugador("Argentina","Francia","Francia"));

        assertTrue("El pronostico del 1er Jugador es Alemania en el partido de Suiza-Alemania",Jugador1.obtenerPronostico
                ("Suiza-Alemania").equals("Alemania"));
        assertTrue("El pronostico del 2do Jugador es Argentina por el partido Suiza-Alemania",Jugador2.obtenerPronostico
                ("Suiza-Alemania").equals("Suiza"));
        assertFalse("El pronostico del 2do Jugador es Peru por el partido Suiza-Alemania",Jugador1.obtenerPronostico
                ("Suiza-Alemania").equals("Suiza"));

        assertTrue("El pronostico del 1er Jugador es Argentina por el partido Argentina-Francia",Jugador1.obtenerPronostico
                ("Argentina-Francia").equals("Argentina"));
        assertTrue("El pronostico del 2do Jugador es Francia por el partido Argentina-Francia",Jugador2.obtenerPronostico
                ("Argentina-Francia").equals("Francia"));
        assertFalse("El pronostico del 2do Jugador es Argentina por el partido Argentina-Francia",Jugador1.obtenerPronostico
                ("Argentina-Francia").equals("Francia"));
    }
}