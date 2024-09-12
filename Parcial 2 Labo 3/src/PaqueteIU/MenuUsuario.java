package PaqueteIU;

import PaqueteModelo.ContenidoVirtual;
import PaqueteInterfaz.Metodos;
import PaqueteExcepcion.VerificacionDuplicados;
import PaqueteContenedor.GestionMetodos;
import PaqueteModelo.Expansion;
import PaqueteModelo.VideoJuego;

import java.util.Collection;
import java.util.Scanner;

public class MenuUsuario <T extends ContenidoVirtual> {
    private GestionMetodos<ContenidoVirtual> gestionMetodos;
    private Scanner scanner;

    public MenuUsuario(){
        gestionMetodos = new GestionMetodos<>();
        scanner = new Scanner(System.in);
    }

    public void menuPrincipal(){
        int opcion;
        do{
            System.out.println("Bienvenidos!!!");
            System.out.println("OPCIONES");
            System.out.println("1. AGREGAR video juego");
            System.out.println("2. AGREGAR extension");
            System.out.println("3. ELIMINAR contenido por ID");
            System.out.println("4. LISTAR contenido virtual");
            System.out.println("5. FILTRAR contenido por genero");
            System.out.println("6. MODIFICAR genero del contenido");
            System.out.println("7. SALIR");
            System.out.println("ELIJA LA OPCION QUE DESEE");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    agregarVideoJuego();
                    break;
                case 2:
                    agregarExtension();
                    break;
                case 3:
                    eliminarporID();
                    break;
                case 4:
                    listarContenido();
                    break;
                case 5:
                    filtrarPorGenero();
                    break;
                case 6:
                    modificarporGenero();
                    break;
                case 7:
                    System.out.println("Saliendo del software, gracias!!!");
                    break;
                default:
                    System.out.println("Opcion invalida :(");
            }
        }
        while (opcion!=7);
    }

    private void agregarVideoJuego(){
        System.out.println("Ingrese el titulo del juego");
        String tituloNuevo = scanner.nextLine();
        System.out.println("Ingrese el creador del juego");
        String creador = scanner.nextLine();
        System.out.println("Ingrese el genero");
        String generoVideoJ = scanner.nextLine();
        System.out.println("Ingrese el ID unico del videoJuego");
        String idJuego = scanner.nextLine();
        System.out.println("Ingrese la version del videoJuego");
        Integer version = scanner.nextInt();

        VideoJuego videoJuego = new VideoJuego(tituloNuevo, creador, generoVideoJ, idJuego, version);

        try {
            gestionMetodos.agregarContenido(videoJuego);
            System.out.println("Video juego agregado exitosamente");
        }catch (VerificacionDuplicados e){
            System.out.println(e.getMessage());
        }
    }
    private void agregarExtension(){
        System.out.println("Ingrese el titulo de la expansion");
        String tituExpansion = scanner.nextLine();
        System.out.println("Ingrese el creador de la expansion");
        String creadorEx = scanner.nextLine();
        System.out.println("Ingrese el genero");
        String generoExpansion = scanner.nextLine();
        System.out.println("Ingrese el ID unico de la expansion");
        String idExpansion = scanner.nextLine();
        System.out.println("Ingrese la fecha de lanzamiento");
        String fechaLanzamiento = scanner.nextLine();

        Expansion expansion = new Expansion(tituExpansion, creadorEx, generoExpansion, idExpansion, fechaLanzamiento);

        try {
            gestionMetodos.agregarContenido(expansion);
            System.out.println("Expansion agregada exitosamente");
        }catch (VerificacionDuplicados e){
            System.out.println(e.getMessage());
        }
    }

    private boolean eliminarporID(){
        System.out.println("Ingrese el ID del contenido a eliminar");
        String idAeliminar = scanner.nextLine();
        boolean eliminacionExitosa = gestionMetodos.eliminarContenido(idAeliminar);
        if (eliminacionExitosa) {
            System.out.println("Se efectuo de manera correcta su eliminacion");
        }
        else {
            System.out.println("No se encontro ningun ID que coincida");
        }
        return eliminacionExitosa;
    }

    private void listarContenido(){
        Collection<ContenidoVirtual> contenidoVirtual = gestionMetodos.listarContenido();
        if (contenidoVirtual.isEmpty()){
            System.out.println("El contenido virtual se encuentra vacio");
        }
        else {
            System.out.println("Contenido virtual: ");
            for (ContenidoVirtual contenidoVirtual1 : contenidoVirtual){
                System.out.println(contenidoVirtual1);
            }
        }
    }

    private void filtrarPorGenero(){
        System.out.println("Ingrese el genero del contenido a filtrar");
        String generoBuscado = scanner.nextLine();
        Collection<ContenidoVirtual> contenido = gestionMetodos.filtrarContenido(generoBuscado);

        if(!contenido.isEmpty()){
            for (ContenidoVirtual resultadoListado : contenido){
                System.out.println(resultadoListado);
            }
        }else {
            System.out.println("No se encontro el genero proporcionado");
        }
    }

    private void modificarporGenero(){
        System.out.println("Ingrese el creador del contenido que quieras eliminar");
        String creadorBuscado = scanner.nextLine();
        Collection<ContenidoVirtual> contenidos = gestionMetodos.filtrarContenido(creadorBuscado);

        if(!contenidos.isEmpty()){
            System.out.println("Contenido encontrado para el creador " + creadorBuscado);
            for (ContenidoVirtual contenido2: contenidos){
                System.out.println(contenido2);
            }

            System.out.println("Ingrese el titulo del contenido a modificar");
            String tituloAmod = scanner.nextLine();
            ContenidoVirtual contenido = null;

            for (ContenidoVirtual resultadoEncontrado : contenidos){
                if (resultadoEncontrado.getTitulo().equals(tituloAmod)){
                    contenido = resultadoEncontrado;
                    break;
                }
            }
            if (contenido!=null){
                System.out.println("Datos antes de la modificacion");
                System.out.println(contenido);

                System.out.println("Solo podra cambiar el genero, INGRESE EL NUEVO GENERO");
                String generoNuevo = scanner.nextLine();

                contenido.setGenero(generoNuevo);
                gestionMetodos.modificarContenido(contenido.getGenero(),contenido);

                System.out.println("MODIFICACION EXITOSA");
            }
            else {
                System.out.println("No se encontro coincidencia con el titulo especificado");
            }
        }
        else {
            System.out.println("No se encontraron coincidencias con dicho genero");
        }
    }

}
