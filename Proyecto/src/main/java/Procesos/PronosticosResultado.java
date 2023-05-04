package Procesos;

import Classes.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PronosticosResultado {
    private Torneo torneo ;
    private List<Jugador> jugadores;
    private Hashtable<Integer, ArrayList<Partido>> resultadosTorneo;

    public PronosticosResultado(Torneo torneo , List<Jugador> jugadores){
        this.torneo = torneo;
        this.jugadores = jugadores;
        this.resultadosTorneo = this.torneo.obtenerResultados();
    }

    /**
     *
     */
    public void start(){
        this.resultadosTorneo.forEach(this::mostradorPantalla);
        Main.pantalla.println();
        this.jugadores.forEach((jugador) -> {
            Main.pantalla.println("Nombre del Jugador: "+ jugador.obtenerNombre() + ", Total de Puntos: " +
                    jugador.obtenerPuntaje() + ", Cantidad de aciertos: "+ jugador.obtenerPuntaje()
            );
        });

        int mayorPuntaje = 0;
        Jugador ganador = null;
        for (Jugador jugador: getJugadores()) {
            if(jugador.obtenerPuntaje() > mayorPuntaje){
                mayorPuntaje = jugador.obtenerPuntaje();
                ganador = jugador;
            }
        }

        Main.pantalla.println(ganador.ganadorJuego());
    }
    public void mostradorPantalla(Integer ronda, ArrayList<Partido> partidos){
        Main.pantalla.println("Ronda: " + ronda + " ");
        partidos.forEach((partido) -> {
            Main.pantalla.println(partido.obtenerPartido());
            jugadores.forEach((jugador) -> {if (jugador.obtenerPronostico(partido.obtenerEquipos()).
                    equals(partido.obtenerResultado())){
                jugador.setearPuntaje(1);
            }
            });
        });

    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
