package library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue
    @Column(name = "loan_id")
    private UUID id;

    @ManyToOne(optional = false) // nella tabella deve crearsi colonna user id FK
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // tutto l oggetto ma id nella colonna

    @ManyToOne(optional = false) //uguale a sopra
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public Loan() {
    }

    public Loan(User user, Item item, LocalDate startDate, LocalDate dueDate, LocalDate returnDate) {
        this.user = user;
        this.item = item;
        this.startDate = LocalDate.now();
        this.dueDate = this.startDate.plusDays(30);
        this.returnDate = returnDate;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
