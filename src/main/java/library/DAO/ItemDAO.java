package library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import library.entities.Item;
import library.exception.NotFoundException;

public class ItemDAO {

    private final EntityManager em;

    public ItemDAO(EntityManager em) {
        this.em = em;
    }

    public void deleteByIsbn(String isbn) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();

            int deleted = em.createQuery(
                            "DELETE FROM Item i WHERE i.isbn = :isbn")
                    .setParameter("isbn", isbn)
                    .executeUpdate();

            t.commit();

            if (deleted > 0) {
                System.out.println("Elemento eliminato");
            } else {
                System.out.println("Elemento non trovato");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Item findByIsbn(String isbn) {
        try {
            return em.createQuery(
                            "SELECT i FROM Item i WHERE i.isbn = :isbn", Item.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();

        } catch (NoResultException e) {
            throw new NotFoundException("Elemento con ISBN " + isbn + " non trovato");
        }
    }
}