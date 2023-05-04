package Classes;

import java.util.ArrayList;

import java.util.Hashtable;


public class Torneo {
    private Hashtable<Integer, ArrayList<Partido>> partidos;

    public Torneo(Hashtable<Integer, ArrayList<Partido>> partidos){

        this.partidos = partidos;
    }

    public Hashtable<Integer, ArrayList<Partido>> obtenerResultados(){
        return  this.partidos;
    }


}
