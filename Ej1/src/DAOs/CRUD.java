package DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CRUD<T> {

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
    protected EntityManager em = emf.createEntityManager();

    protected void conectar() {
        if (em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();

    }

    protected void agregar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    public T eliminar(T objeto) throws Exception {
        try {
            conectar();
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            desconectar();
            throw new Exception("La entidad de tipo " + objeto.getClass().getSimpleName()
                    + " no se ha podido eliminar");
        }

        return objeto;

    }

}
