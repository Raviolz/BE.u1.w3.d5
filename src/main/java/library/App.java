package library;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import library.DAO.*;
import library.entities.*;
import library.exception.NotFoundException;

import java.time.LocalDate;


public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");

    public static void main(String[] args) {


        EntityManager em = emf.createEntityManager();
        BookDAO bookDAO = new BookDAO(em);
        MagazineDAO magazineDAO = new MagazineDAO(em);
        UserDAO userDAO = new UserDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);

        // TEST PERSIST

        // Book n Magazine
        Book b1 = new Book("978-8804668237", 1954, 1178, "Il Signore degli Anelli", "J.R.R. Tolkien", Genre.FANTASY);
        Book b2 = new Book("978-8806222413", 1949, 328, "1984", "George Orwell", Genre.SCIFI);
        Book b3 = new Book("978-8830415058", 1939, 212, "Dieci Piccoli Indiani", "Agatha Christie", Genre.THRILLER);
        Book b4 = new Book("978-8804719113", 2018, 528, "Il Fuoco e il Sangue", "George R.R. Martin", Genre.FANTASY);

        Magazine m1 = new Magazine("1234-5678", 2024, 60, "National Geographic", Frequency.MONTHLY);
        Magazine m2 = new Magazine("8765-4321", 2024, 45, "Time Magazine", Frequency.WEEKLY);

//
//        try {
//            bookDAO.save(b1);
//            bookDAO.save(b2);
//            bookDAO.save(b3);
//            bookDAO.save(b4);
//            bookDAO.save(new Book("978-8807901300", 1943, 96, "Il Piccolo Principe", "Antoine de Saint-Exupéry", Genre.CHILDREN));
//            magazineDAO.save(m1);
//            magazineDAO.save(m2);
//            magazineDAO.save(new Magazine("1122-3344", 2023, 120, "Vogue", Frequency.MONTHLY));
//            System.out.println("Salvataggio completato con successo!");
//        } catch (Exception e) {
//            System.err.println("Errore durante il salvataggio: " + e.getMessage());
//        }


        //  User

        User u1 = new User("Marco", "Rossi", LocalDate.of(1974, 11, 9));
        User u2 = new User("Piero", "Baggio", LocalDate.of(1967, 2, 18));
        User u3 = new User("Federica", "Pellegrini", LocalDate.of(1988, 8, 5));


//        try {
//            userDAO.save(u1);
//            userDAO.save(u2);
//            userDAO.save(u3);
//            userDAO.save(new User("Piera", "Baldelli", LocalDate.of(1955, 5, 1)));
//        } catch (Exception e) {
//            System.err.println("Errore durante il salvataggio: " + e.getMessage());
//        }

        //  loan


        Loan l1 = new Loan(u1, b1);
        Loan l2 = new Loan(u2, m1);

//        try {
//            loanDAO.save(new Loan(u3, b1));
//            loanDAO.save(l1);
//            loanDAO.save(l2);
//        } catch (Exception e) {
//            System.err.println("Errore durante il salvataggio: " + e.getMessage());
//        }


        // REMOVE ISBN

        ItemDAO itemDAO = new ItemDAO(em);
//        itemDAO.deleteByIsbn("978-8806222413"); // ora eliminato
//        itemDAO.deleteByIsbn("123");


        // FIND BY ISBN

        try {
            Item foundErr = itemDAO.findByIsbn("00");
            System.out.println(foundErr);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Item foundIsbn = itemDAO.findByIsbn("978-8830415058");
            System.out.println(foundIsbn);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        em.close();
        emf.close();
    }
}
