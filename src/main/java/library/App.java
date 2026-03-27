package library;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");

    public static void main(String[] args) {


        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
