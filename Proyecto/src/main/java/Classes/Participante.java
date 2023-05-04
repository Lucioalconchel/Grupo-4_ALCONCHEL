package Classes;
public interface Participante {
    String obtenerNombre();

    void setearPuntaje(int punto);

    int obtenerPuntaje();

    String ganadorJuego();

    String obtenerPronostico(String encuentro);
}
