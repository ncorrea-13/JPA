package libreria.servicios;

import DAOs.EditorialDao;
import java.util.Scanner;
import libreria.entidades.Editorial;

public class EditorialService {

    protected EditorialDao DAO = new EditorialDao();
    protected Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Editorial crearEditorial() throws Exception {
        try {
            System.out.println("Dicte el id de su editorial");
            Long id = leer.nextLong();

            Editorial editorial = DAO.crearEditorial(id);
            return editorial;
        } catch (Exception ex) {
            throw ex;
        }

    }
}
