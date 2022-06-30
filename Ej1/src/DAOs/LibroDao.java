package DAOs;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroDao extends CRUD {

    public LibroDao() {
    }

    public void crearLibro(String nombre, int anio, int total, int prestados, int resto, Autor autor, Editorial editorial) throws Exception {

        Libro libro = new Libro();
        try {
            libro.setAlta(true);
            libro.setAnio(anio);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(total);
            libro.setEjemplaresPrestados(prestados);
            libro.setEjemplaresRestantes(resto);
            libro.setTitulo(nombre);

            boolean a = verificarLibro(libro, nombre);

            if (a = false) {
                System.out.println("El libro ya se encuentra agregado");
            } else {
                agregar(libro);
                System.out.println("Se a agregado el libro");
            }

        } catch (Exception ex) {

        }
    }

    public boolean verificarLibro(Libro libro, String nombre) {

        try {
            conectar();
            Libro nuevo = (Libro) em.createQuery("Select a "
                    + "From Libro a "
                    + "Where a.titulo LIKE :nombre").
                    setParameter("nombre", nombre).getSingleResult();

            if (nuevo == null) {
                return true;
            } else if (nuevo == libro) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            return false;
        }

    }
    
    public Libro buscarPorISBN(Long numero){
        Libro libroBuscado = em.find(Libro.class, numero);
        
        if (libroBuscado == null) {
            return null;
        } else {
            return libroBuscado;
        }
    }

    public Libro buscarPorNombre(String NombreBuscado) {

        conectar();
        Libro nombreBuscado = (Libro) em.createQuery("Select a "
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
