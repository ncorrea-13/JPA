package libreria.servicios;

import DAOs.AutorDao;
import java.util.Scanner;
import libreria.entidades.Autor;

public class AutorService {

    protected AutorDao DAO = new AutorDao();
    protected Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Autor crearAutor() throws Exception {
        try {
            System.out.println("Ingrese el id de su autor");
            Long id = leer.nextLong();

            Autor autor = DAO.crearAutor(id);
            return autor;
        } catch (Exception ex) {
            throw ex;
        }

    }

    public void buscarAutor() throws Exception {
        try {
            System.out.println("Escriba el nombre del autor a buscar");

            Autor autor = DAO.buscarPorNombre(leer.nextLine());

            if (autor == null) {
                System.out.println("El autor no se encuentra en el sistema");
            } else {
                System.out.println(autor.toString());
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

}
