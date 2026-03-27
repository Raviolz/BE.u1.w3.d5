package library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import library.entities.User;

public class UserDAO {

    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User newUser) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newUser);

        transaction.commit();

        System.out.println("L'utente " + newUser.getFirstName() + " " + newUser.getLastName() + " è stato salvato con successo!");
    }
}
