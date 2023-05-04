package Classes;

public class Equipo {

    private String nombre;

    private String descripcion;

    public Equipo(String nombre, String descripcion) {
        this.setearNombre(nombre);
        this.setearDescripcion(descripcion);
    }


    public String obtenerNombre() {
        return this.nombre;
    }
    public String obtenerDescripcion(){
        return this.descripcion;
    }

    public void setearNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setearDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
