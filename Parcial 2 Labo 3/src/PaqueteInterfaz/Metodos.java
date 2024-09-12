package PaqueteInterfaz;

import PaqueteExcepcion.VerificacionDuplicados;
import PaqueteModelo.ContenidoVirtual;

import java.util.Collection;

public interface Metodos <T extends ContenidoVirtual> {
    void agregarContenido (T contenido) throws VerificacionDuplicados;
    boolean eliminarContenido (String idAeliminar);
    Collection<T> listarContenido();
    Collection<T> filtrarContenido (String genero);
    void  modificarContenido (String genero, T contenido);

}
