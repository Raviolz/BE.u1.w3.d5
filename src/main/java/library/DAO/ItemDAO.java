package library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import library.entities.Item;
import library.exception.NotFoundException;

import java.util.List;

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
                            "SELECT i FROM Item i WHERE i.isbn = :isbn ", Item.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();

        } catch (NoResultException e) {
            throw new NotFoundException("Elemento con ISBN " + isbn + " non trovato");
        }
    }


    public List<Item> findByPubYear(int year) {
        List<Item> results = em.createQuery(
                        "SELECT i FROM Item i WHERE i.publicationYear = :year", Item.class)
                .setParameter("year", year)
                .getResultList();

        if (results.isEmpty()) {
            throw new NotFoundException("Nessun elemento trovato per l'anno " + year);
        }

        return results;
    }


    public List<Item> findByTitle(String title) {
        List<Item> results = em.createQuery(
                        "SELECT i FROM Item i WHERE LOWER(i.title) LIKE LOWER(:title)", Item.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();

        if (results.isEmpty()) {
            throw new NotFoundException("Nessun elemento trovato con titolo contenente: " + title);
        }

        return results;
    }
}