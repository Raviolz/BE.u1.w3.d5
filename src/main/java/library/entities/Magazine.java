package library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "magazines")
public class Magazine extends Item {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Frequency frequency;


    public Magazine() {
    }

    ;

    public Magazine(String isbn, int publicationYear, int pages, String title, Frequency frequency) {
        super(isbn, publicationYear, pages, title);
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getItemId() +
                ", isbn='" + getIsbn() + '\'' +
                ", publicationYear=" + getPublicationYear() +
                ", pages=" + getPages() +
                ", title='" + getTitle() + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
