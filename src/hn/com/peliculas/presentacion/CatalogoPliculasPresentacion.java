package hn.com.peliculas.presentacion;

import hn.com.peliculas.servicio.*;
import java.util.Scanner;

/**
 *
 * @author Omar Lopez
 */
public class CatalogoPliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while(opcion !=0){
            System.out.println("Elige una opcion: \n"
                + "1. Iniciar catalogo de peliculas \n"
                + "2. Agregat Pelicula \n"
                + "3. Listar Peliculas \n"
                + "4. Buscar Pelicula \n"
                + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listraPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPeliculas(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default :
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
    }
}
