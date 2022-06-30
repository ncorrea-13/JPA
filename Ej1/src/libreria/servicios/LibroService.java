package libreria.servicios;

import DAOs.LibroDao;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroService {

    protected LibroDao Dao;
    protected AutorService autorService;
    protected EditorialService editorialService;
    protected Scanner leer;

    public LibroService() {
        Dao = new LibroDao();
        autorService = new AutorService();
        editorialService = new EditorialService();
        leer = new Scanner(System.in).useDelimiter("\n");
    }

    public void crearLibro() throws Exception {

        try {
            System.out.println("Dicte el nombre de su libro");
            String nombre = leer.nextLine();

            System.out.println("Dicte el año de su publicación");
            int anio = leer.nextInt();

            System.out.println("Dicte la cantidad de ejemplares que posee");
            int cantidadDeEjemplares = leer.nextInt();

            System.out.println("Dicte la cantidad que han sido prestados");
            int cantidadPrestados = leer.nextInt();

            int cantidadRestantes = cantidadDeEjemplares - cantidadPrestados;

            Autor autor = autorService.crearAutor();

            Editorial editorial = editorialService.crearEditorial();

            Dao.crearLibro(nombre, anio, cantidadDeEjemplares, cantidadPrestados, cantidadRestantes, autor, editorial);
        } catch (Exception ex) {
            throw ex;
        }

    }

    public void buscarLibroPorISBN() {
        try {
            System.out.println("Ingrese el código de su libro");

            Libro libro = Dao.buscarPorISBN(leer.nextLong());

            if (libro == null) {
                System.out.println("El libro no se encuentra en el sistema");
            } else {
                System.out.println(libro.toString());
            }
            
            
        } catch (Exception ex) {
            throw ex;
        }

    }

    public void buscarLibroPorNombre() {
        try {
            System.out.println("Escriba el nombre del libro a buscar");

            Libro libro = Dao.buscarPorNombre(leer.nextLine());

            if (libro == null) {
                System.out.println("El libro no se encuentra en el sistema");
            } else {
                System.out.println(libro.toString());
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

}
