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

}
