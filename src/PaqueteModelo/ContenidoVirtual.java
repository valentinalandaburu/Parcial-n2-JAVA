package PaqueteModelo;

public abstract class ContenidoVirtual {

    private String titulo;
    private String creador;
    private String genero;
    private String idUnico;

    public ContenidoVirtual(String titulo, String creador, String genero, String idUnico) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.idUnico = idUnico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(String idUnico) {
        this.idUnico = idUnico;
    }

    @Override
    public String toString() {
        return "ContenidoVirtual: " +
                " titulo:  " + titulo + '\'' +
                ",  creador:  " + creador + '\'' +
                ",  genero:  " + genero + '\'' +
                ",  idUnico:  " + idUnico + '\'';
    }
}
