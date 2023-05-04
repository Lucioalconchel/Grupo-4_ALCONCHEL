package Classes;

import static org.junit.Assert.*;
import  org.junit.Test;

public class EquipoTest {

    @Test
    public  void  testCrearEquipo(){
        Equipo E1 = new Equipo("Boca","");
        Equipo E2 = new Equipo("River","");
        assertTrue("El 1er equipo esta Creado ",E1 != null);
        assertTrue("El 2do equipo esta Creado ",E2 != null);
        assertTrue("El nombre del 1er equipo es Boca",E1.obtenerNombre().equals("Boca"));
        assertTrue("El nombre del 2do equipo no es Colón",E2.obtenerNombre().equals(" es River"));
    }

}