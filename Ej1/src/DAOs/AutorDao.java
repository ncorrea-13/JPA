package DAOs;

import java.util.ArrayList;
import java.util.Scanner;
import libreria.entidades.Autor;

public class AutorDao extends CRUD<Autor> {

    protected Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Autor crearAutor(Long id) throws Exception {
        
        conectar();
        
        Autor b = em.find(Autor.class, id);

        if (b == null) {
            Autor autor = new Autor();
            System.out.println("Va a crear un nuevo autor");

            System.out.println("Dicte el nombre de su autor");
            String nombre = leer.nextLine();
            autor.setNombre(nombre);
            autor.setAlta(true);

            agregar(autor);
            return autor;
        } else {
            return b;
        }
    }
    
    public Autor buscarPorNombre(String NombreBuscado) throws Exception {

        conectar();
        Autor nombreBuscado = (Autor) em.createQuery("Select a "
                + "From Libro a "
                + "Where a.titulo LIKE :nombre").
                setParameter("nombre", NombreBuscado).
                getSingleResult();

        desconectar();

        if (nombreBuscado == null) {
            return null;
        } else {
            return nombreBuscado;
        }

    }
    
    
}
