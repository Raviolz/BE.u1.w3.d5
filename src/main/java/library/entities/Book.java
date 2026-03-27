package library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Book extends Item {

    @Column(nullable = false, length = 50)
    private String author;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Book() {

    }

    ;

    public Book(String isbn, int publicationYear, int pages, String title, String author, Genre genre) {
        super(isbn, publicationYear, pages, title);
        this.author = author;
        this.genre = genre;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getItemId() +
                ", isbn='" + getIsbn() + '\'' +
                ", publicationYear=" + getPublicationYear() +
                ", pages=" + getPages() +
                ", title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}

