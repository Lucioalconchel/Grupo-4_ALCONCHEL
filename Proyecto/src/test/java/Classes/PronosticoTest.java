package Classes;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PronosticoTest {
    public ArrayList<String> crearListaDelPronostico(String Local,String Visitante, String Resultado){
        ArrayList<String> lista = new ArrayList<>();
        lista.add(Local);
        lista.add(Visitante);
        lista.add(Resultado);
        return lista;
    }
    @Test
    public void testCrearPronostico(){
        Pronostico P = new Pronostico(crearListaDelPronostico("España","Italia","Empate"));
        assertTrue("El Pronostico fue creado",P != null);

    }

    @Test
    public void testResultadoPronostico(){
        Pronostico P1 = new Pronostico(crearListaDelPronostico("Italia","Egipto","Empate"));
        Pronostico P2 = new Pronostico(crearListaDelPronostico("Italia","Egipto","Italia"));
        Pronostico P3 = new Pronostico(crearListaDelPronostico("Italia","Egipto","Egipto"));

        assertTrue("El 1er Pronostico fue creado",P1 != null);
        assertTrue("El 2do Pronostico fue creado",P2 != null);
        assertTrue("El 3ro Pronostico fue creado",P3 != null);

        assertTrue("El 1er Pronostico es el esperado",P1.obtenerPronostico().equals("Empate"));
        assertTrue("El 2do Pronostico es el esperado",P2.obtenerPronostico().equals("Italia"));
        assertTrue("El 3ro Pronostico es el esperado",P3.obtenerPronostico().equals("Egipto"));

    }
}