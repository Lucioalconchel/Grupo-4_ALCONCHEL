package Procesos;


import Classes.Jugador;
import Classes.Partido;
import Classes.Torneo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static final java.io.PrintStream pantalla = new java.io.PrintStream(System.out);

    public  static List<Jugador> ListaJugadores(String path_archivo){
        Hashtable<String,Jugador> hashJugadores = new Hashtable<>();
        try {
            String line;
            File archivo = new File(path_archivo);
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            reader.readLine();


            while((line = reader.readLine()) != null){
                ArrayList<String> lista =  new ArrayList<String>();

                for( String dato: line.split(",")){
                    lista.add(dato);
                }

                if(!hashJugadores.containsKey(lista.get(0))){
                    hashJugadores.put(lista.get(0),new Jugador(lista.remove(0),lista));
                }else{
                    hashJugadores.get(lista.remove(0)).cargarPronosticos(lista);
                }
            }
        }catch (Exception err){
            pantalla.println(err);
        }
        List<Jugador> jugadores = new ArrayList<>();
        hashJugadores.forEach((clave , valor) ->{
            jugadores.add(valor);
        });
        return jugadores;
    }

    public static Hashtable<Integer, ArrayList<Partido>> ListaPartidos(String path_archivo) {

        Hashtable<Integer, ArrayList<Partido>> partidos = new Hashtable<Integer, ArrayList<Partido>>();

        try {
            String line;
            File archivo = new File(path_archivo);
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            reader.readLine();


            while((line = reader.readLine()) != null){
                ArrayList<String> lista =  new ArrayList<String>();

                for( String dato: line.split(",")){

                    lista.add(dato);
                }


                int ronda = Integer.parseInt(lista.remove(0));
                if( esNumero(String.valueOf(ronda))){
                    if(!partidos.containsKey(ronda)){
                        ArrayList<Partido> listaPartido = new ArrayList<>();
                        listaPartido.add(new Partido(lista));
                        partidos.put(ronda, listaPartido);
                    }else{
                        partidos.get(ronda).add(new Partido(lista));
                    }
                }else{
                    throw new ErrorException();
                }

            }

        }catch (Exception err){
            Main.pantalla.println(err);

        }

        return partidos;
    }

    public static boolean esNumero(String dato) throws NumberFormatException, ErrorException {

        try {
            int aux = Integer.parseInt(dato);
        }catch (NumberFormatException e){
            pantalla.println("Debe ingresar un número");
        }

        if( Integer.parseInt(dato) > -1){
            return true;
        }else{
            throw new ErrorException();
        }
    }

    public static void main(String[] args) {
        Torneo torneo = new Torneo(ListaPartidos("..\\Grupo-4_ALCONCHEL\\Proyecto\\resources\\Archivos\\ResultadosPartidos.csv"));
        PronosticosResultado pronosticoJuego = new PronosticosResultado(torneo,ListaJugadores("..\\Grupo-4_ALCONCHEL\\Proyecto\\resources\\Archivos\\PronosticosJugador1.csv"));
        pronosticoJuego.start();
    }
}