package PaqueteModelo;

public class VideoJuego extends ContenidoVirtual{

    private Integer nroVersion;

    public VideoJuego(String titulo, String creador, String genero, String idUnico, Integer nroVersion) {
        super(titulo, creador, genero, idUnico);
        this.nroVersion = nroVersion;
    }

    public Integer getNroVersion() {
        return nroVersion;
    }

    public void setNroVersion(Integer nroVersion) {
        this.nroVersion = nroVersion;
    }

    @Override
    public String toString() {
        return "VideoJuego: " +
                "nroVersion: " + nroVersion + super.toString();
    }
}
