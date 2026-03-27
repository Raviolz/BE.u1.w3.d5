package library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import library.entities.Book;

public class BookDAO {
    private final EntityManager entityManager;

    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Book newBook) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newBook);

        transaction.commit();

        System.out.println("Il libro " + newBook.getTitle() + " è stato salvato con successo!");
    }
}

