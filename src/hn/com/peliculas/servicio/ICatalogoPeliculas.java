package hn.com.peliculas.servicio;

/**
 *
 * @author Omar Lopez
 */
public interface ICatalogoPeliculas {
    static final String NOMBRE_RECURSO = "peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    
    void listraPeliculas();
    
    void buscarPeliculas(String buscar);
    
    void iniciarCatalogoPeliculas();
}
