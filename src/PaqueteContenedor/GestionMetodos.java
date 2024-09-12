package PaqueteContenedor;

import PaqueteModelo.ContenidoVirtual;
import PaqueteInterfaz.Metodos;
import PaqueteExcepcion.VerificacionDuplicados;

import java.util.*;

public class GestionMetodos <T extends ContenidoVirtual> implements Metodos<T> {

    private Map<String, T> coleccionContenido;

    public GestionMetodos(){
        coleccionContenido = new HashMap<>();
    }

    @Override
    public void agregarContenido(T contenido) throws VerificacionDuplicados {
        if(!coleccionContenido.containsKey(contenido.getIdUnico())){
            coleccionContenido.put(contenido.getIdUnico(),contenido);
        }else {
            throw new VerificacionDuplicados("ERROR, el id ya esta siendo utilizado:(");
        }
    }

    @Override
    public boolean eliminarContenido(String idAeliminar) {
        if(coleccionContenido.containsKey(idAeliminar)){
            coleccionContenido.remove(idAeliminar);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Collection<T> listarContenido() {
        return coleccionContenido.values();
    }

    @Override
    public Collection<T> filtrarContenido(String genero) {
        List<T> resultadosFiltrados =new ArrayList<>();
        for (T contenido : coleccionContenido.values()){
            if (contenido.getGenero().equals(genero)){
                resultadosFiltrados.add(contenido);
            }
        }
        return resultadosFiltrados;
    }

    @Override
    public void modificarContenido(String genero, T contenido) {
            coleccionContenido.put(contenido.getGenero(),contenido);
        System.out.println("MODIFICACION EXITOSA");
    }
}





