package library.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private UUID itemId;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(name = "publication_year")
    private int publicationYear;

    private int pages;

    @Column(nullable = false, length = 50)
    private String title;

    public Item() {
    }

    ;

    public Item(String isbn, int publicationYear, int pages, String title) {
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.title = title;
    }


    public UUID getItemId() {
        return itemId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    ;

    @Override
    public String toString() {
        return "Item{" +
                "bookId=" + itemId +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                '}';
    }
}
