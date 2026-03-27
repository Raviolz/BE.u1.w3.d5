package library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import library.entities.Item;
import library.entities.Loan;
import library.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public class LoanDAO {

    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loan newLoan) {
        EntityTransaction transaction = this.em.getTransaction();

        transaction.begin();

        em.persist(newLoan);

        transaction.commit();

        System.out.println("Il prestito è stato salvato con successo!");
    }


    public List<Item> findLentOnMember(UUID membershipNumber) {
        List<Item> items = em.createQuery(
                        "SELECT l.item FROM Loan l WHERE l.user.membershipNumber = :membershipNumber AND l.returnDate IS NULL", // .item perche' : i prestati non i prestiti
                        Item.class)
                .setParameter("membershipNumber", membershipNumber)
                .getResultList();

        if (items.isEmpty()) {
            throw new NotFoundException("Non abbiamo prestato niente a questo numero di tessera " + membershipNumber);
        }

        return items;
    }
}

