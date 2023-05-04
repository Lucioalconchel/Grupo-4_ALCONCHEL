package Classes;

import java.util.ArrayList;
import java.util.Hashtable;

public class Jugador implements Participante{
    private String nombre;
    private int puntaje;
    private Hashtable<String, Pronostico> pronosticos ;

    public Jugador(String nombre , ArrayList<String> lista){
        this.nombre = nombre;
        this.puntaje = 0;
        this.pronosticos = new Hashtable<>();
        this.cargarPronosticos(lista);

    }

    public String obtenerNombre(){
        return  this.nombre;
    }

    public int obtenerPuntaje(){
        return  this.puntaje;
    }

    public String ganadorJuego() {
        return "El ganador es: " + this.obtenerNombre() + ", obtuvo "+this.obtenerPuntaje()+" puntos";
    }

    @Override
    public String obtenerPronostico(String encuentro) {
        return  pronosticos.containsKey(encuentro)? pronosticos.get(encuentro).obtenerPronostico(): null;
    }

    public void setearPuntaje(int punto){
        this.puntaje += punto;
    }

    public void cargarPronosticos(ArrayList<String> lista){
        String partido = lista.get(0)+"-"+lista.get(1);
        pronosticos.put(partido,new Pronostico(lista));
    }


}
