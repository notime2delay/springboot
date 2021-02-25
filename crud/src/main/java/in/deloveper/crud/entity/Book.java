package in.deloveper.crud.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "book")
@NamedQuery(name = "Book.FindAll", query = "select b from Book b")
public class Book implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "isbn",columnDefinition = "BINARY(16)")
    private UUID isbn;

    private String bookName;

    private String author;

    public UUID getIsbn() {
        return isbn;
    }

    public void setBookID(UUID isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
