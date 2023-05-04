package Classes;

import Procesos.ErrorException;
import java.util.ArrayList;

public class Partido {
    private  int golesDeLocal;
    private int golesDeVisitante;
    private String empate = "empate";
    private Equipo equipoLocal, equipoVisitante;

    public  Partido (ArrayList<String> listaPartido) throws ErrorException{
        equipoLocal = new Equipo(listaPartido.get(0),"" );
        equipoVisitante = new Equipo(listaPartido.get(1),"" );

        if(Integer.parseInt(listaPartido.get(2)) < 0){
            throw new ErrorException();
        }
        this.golesDeLocal = Integer.parseInt(listaPartido.get(2));

        if(Integer.parseInt(listaPartido.get(3)) < 0){
            throw new ErrorException();
        }
        this.golesDeVisitante = Integer.parseInt(listaPartido.get(3));

    }


    public String obtenerEquipoLocalNombre() {
        return this.equipoLocal.obtenerNombre();
    }

    public String obtenerEquipoVisitanteNombre() {
        return this.equipoVisitante.obtenerNombre();
    }

    public int obtenerGolesLocal() {
        return golesDeLocal;
    }

    public int obtenerGolesVisitante() {
        return golesDeVisitante;
    }


    public String obtenerResultado() {

        if( this.obtenerGolesLocal() > this.obtenerGolesVisitante()){
            return this.obtenerEquipoLocalNombre();
        }
        else if( this.obtenerGolesLocal() < this.obtenerGolesVisitante()){
            return this.obtenerEquipoVisitanteNombre();
        }
        return this.empate;
    }


    public  String obtenerPartido(){
        String resultado = this.obtenerResultado();
        String noEmpate = "Equipo Local: " + this.obtenerEquipoLocalNombre() + "; " + "Equipo Visitante: " + this.obtenerEquipoVisitanteNombre() +"; " + "Resultado Final: " + this.golesDeLocal + "-" + this.golesDeVisitante;

        if (resultado.equals(this.empate)){
            noEmpate += " Empate";

        }else{
            noEmpate += "; Equipo Ganador: " + resultado;
        }
        return noEmpate;

    }

    public String obtenerEquipos(){
        return this.obtenerEquipoLocalNombre()+"-"+this.obtenerEquipoVisitanteNombre();
    }

}