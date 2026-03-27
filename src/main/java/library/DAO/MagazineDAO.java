package library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import library.entities.Magazine;

public class MagazineDAO {

    private final EntityManager entityManager;

    public MagazineDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Magazine newMagazine) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newMagazine);

        transaction.commit();

        System.out.println("La rivista " + newMagazine.getTitle() + " è stata salvata con successo!");
    }
}