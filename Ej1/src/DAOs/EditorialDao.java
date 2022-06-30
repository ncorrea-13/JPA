package DAOs;

import java.util.Scanner;
import libreria.entidades.Editorial;

public class EditorialDao extends CRUD {

    protected Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Editorial crearEditorial(Long id) throws Exception {

        Editorial editorial1 = em.find(Editorial.class, id);

        if (editorial1 == null) {
            Editorial editorial = new Editorial();
            System.out.println("Va a crear una nueva editorial");

            System.out.println("Dicte el nombre de su editorial");
            String nombre = leer.nextLine();
            editorial.setNombre(nombre);
            editorial.setAlta(true);

            agregar(editorial);
            return editorial;
        } else {
            return editorial1;
        }
    }

}
