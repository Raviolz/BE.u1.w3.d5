package library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import library.entities.Book;
import library.exception.NotFoundException;

import java.util.List;

public class BookDAO {
    private final EntityManager em;

    public BookDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Book newBook) {
        EntityTransaction transaction = this.em.getTransaction();

        transaction.begin();

        em.persist(newBook);

        transaction.commit();

        System.out.println("Il libro " + newBook.getTitle() + " è stato salvato con successo!");
    }


    public List<Book> findByAuthor(String author) {
        List<Book> foundBooks = em.createQuery(
                        "SELECT b FROM Book b WHERE LOWER(b.author) LIKE LOWER(:author)", Book.class)
                .setParameter("author", "%" + author + "%")
                .getResultList();

        if (foundBooks.isEmpty()) {
            throw new NotFoundException("Nessun libro trovato per l'autore " + author);
        }

        return foundBooks;
    }
}

