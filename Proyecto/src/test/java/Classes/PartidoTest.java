package Classes;

import Procesos.ErrorException;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PartidoTest {

    public ArrayList<String>  crearListaEncuentro(String Local, String Visitante, String golesDeLocal,String golesDeVisitante){
        ArrayList<String> partido = new ArrayList<>();
        partido.add(Local);partido.add(Visitante);partido.add(golesDeLocal);partido.add(golesDeVisitante);
        return  partido;
    }
    @Test
    public  void testCrearPartido() throws ErrorException {
        Partido P1 = new Partido(crearListaEncuentro("Francia","Uruguay","1","0"));
        Partido P2 = new Partido(crearListaEncuentro("Francia","Uruguay","1","0"));
        assertTrue("El 1er Partido fue creado",P1 != null);
        assertTrue("El 2do Partido fue creado",P2 != null);
    }

    @Test
    public void testVerificarDatosDelPartido() throws ErrorException {
        Partido P1 = new Partido(crearListaEncuentro("Francia","Uruguay","2","0"));
        Partido P2 = new Partido(crearListaEncuentro("Colombia","Uruguay","1","0"));

        assertTrue("El Equipo Local del 1er Partido es Francia",P1.obtenerEquipoLocalNombre().equals("Francia"));
        assertTrue("El Equipo Local del 2do Partido es Colombia",P2.obtenerEquipoLocalNombre().equals("Colombia"));

        assertTrue("El Equipo Visitante del 1er Partido es Uruguay",P1.obtenerEquipoVisitanteNombre().equals("Uruguay"));
        assertTrue("El Equipo Visitante del 2do Partido es Uruguay",P2.obtenerEquipoVisitanteNombre().equals("Uruguay"));

        assertTrue("El Equipo Local del 1er Partido hizo 2 goles",P1.obtenerGolesLocal() == 2);
        assertTrue("El Equipo Visitante del 1er Partido hizo 0 gol",P1.obtenerGolesVisitante() == 0);

        assertTrue("El Equipo Local del 2do Partido hizo 1 gol",P2.obtenerGolesLocal() == 1);
        assertTrue("El Equipo Visitante del 2do Partido hizo 0 gol",P2.obtenerGolesVisitante() == 0);
    }



}