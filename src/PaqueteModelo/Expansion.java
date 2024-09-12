package PaqueteModelo;

public class Expansion extends ContenidoVirtual{

    private String fechaLanzamiento;

    public Expansion(String titulo, String creador, String genero, String idUnico, String fechaLanzamiento) {
        super(titulo, creador, genero, idUnico);
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Expansion:"  +
                "fechaLanzamiento: " + fechaLanzamiento + '\'' + super.toString();
    }
}
