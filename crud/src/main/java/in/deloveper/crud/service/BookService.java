package in.deloveper.crud.service;

import in.deloveper.crud.entity.Book;
import in.deloveper.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.
                findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(UUID bookId, Book book) {
        Book bookData = bookRepository.findById(bookId).orElse(null);
        if (null != book) {
            book.setBookID(bookId);
        }
        return bookRepository.save(book);
    }

    
    public Book getBookByID(UUID bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void deleteBookByID(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
}
