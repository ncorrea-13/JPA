package libreria;

import java.util.Scanner;
import libreria.servicios.AutorService;
import libreria.servicios.EditorialService;
import libreria.servicios.LibroService;

public class Ej1 {

    public static void main(String[] args) {
        LibroService libro = new LibroService();
        AutorService autor = new AutorService();
        EditorialService editorial = new EditorialService();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {

            System.out.println("Bienvenido a la bibloteca universal de Dorrego");

            System.out.println("Que desea realizar?");
            System.out.println("Opción 1: Agregar un nuevo libro");
            System.out.println("Opción 2: Agregar un nuevo autor");
            System.out.println("Opción 3: Agregar una nueva editorial");
            System.out.println("Opción 4: Buscar un libro por su ISBN");
            System.out.println("Opción 5: Buscar un libro por su nombre");
            System.out.println("Opción 6: Bucar un autor por su nombre");
            System.out.println("Opción 7: Buscar un libro por su autor");
            System.out.println("Opción 8: Buscar un libro por su editorial");
            System.out.println("Opción 9: Salir del sistema");

            switch (leer.nextInt()) {
                case 1:
                    libro.crearLibro();
                    break;
                case 2:
                    autor.crearAutor();
                    break;
                case 3:
                    editorial.crearEditorial();
                    break;
                case 4:
                    libro.buscarLibroPorISBN();
                    break;
                case 5:
                    libro.buscarLibroPorNombre();
                    break;
                case 6:
                    autor.buscarAutor();
                    break;
                case 7:
                    libro.buscarLibroPorAutor();
                    break;
                case 8:
                    libro.buscarLibroPorEditorial();
                    break;
                case 9:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("No ha ingresado una opción válida");
                    System.out.println("Se apagará el sistema para ahorrar recursos");
            }

        } catch (Exception ex) {
            System.out.println("Error del sistema");
            System.out.println("Código de error " + ex.toString());
        }

    }

}
