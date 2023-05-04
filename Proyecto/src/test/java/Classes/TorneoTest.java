package Classes;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Hashtable;
import static org.junit.Assert.*;

public class TorneoTest {
    Torneo T;

    @Test
    public void testCrearTorneo(){
        assertTrue("El torneo ha sido creado",T != null);
        assertFalse("El torneo no es null ",T == null);
    }

    @Test
    public void testVerificarLosPartidos(){
        Hashtable<Integer, ArrayList<Partido>> partidos = T.obtenerResultados();

        assertTrue("El torneo tiene una ronda",partidos.containsKey(1));
        assertTrue("El torneo tiene dos rondas",partidos.containsKey(2));
        assertTrue("En la primera ronda jugó Suiza - Egipto ",partidos.get(1).get(0).obtenerEquipos().equals("Suiza-Egipto"));
        assertTrue("En la segunda ronda se jugó Italia - Egipto ",partidos.get(2).get(0).obtenerEquipos().equals("Italia-Egipto"));
    }

}