package hn.com.peliculas.datos;

import hn.com.peliculas.domain.Pelicula;
import hn.com.peliculas.excepciones.*;
import hn.com.peliculas.excepciones.EscrituraDatosEx;
import hn.com.peliculas.excepciones.LecturaDatosEx;
import java.io.*;
import java.util.*;
/**
 *
 * @author Omar Lopez
 */
public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreRecurso){
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al listar peliculas: " + ex.getMessage());        
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito información al archivo" + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepción al escribir peliculas: " + ex.getMessage());        
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula "+ linea + " Encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al bucar pelicula: " + ex.getMessage());  
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepción al buscar pelicula: " + ex.getMessage());  
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepción al crear el archivo: " + ex.getMessage());  
        }
    }

    @Override
    public void borrar(String nombreRecurso){
        var archivo = new File(nombreRecurso);
        if (archivo.exists()){
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }
    }
    
}
