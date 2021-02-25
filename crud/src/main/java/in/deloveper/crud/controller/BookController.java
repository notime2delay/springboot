package in.deloveper.crud.controller;

import in.deloveper.crud.entity.Book;
import in.deloveper.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController implements Serializable {

    @Autowired
    BookService bookService;

    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update/{bookIsbn}")
    public Book updateBook(@PathVariable("bookIsbn") UUID bookIsbn,@RequestBody Book book) {
        return bookService.updateBook(bookIsbn, book);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/getById/{bookIsbn}")
    public Book getBookById(@PathVariable("bookIsbn") UUID bookIsbn) {
        return bookService.getBookByID(bookIsbn);
    }

    @DeleteMapping("deleteById/{bookIsbn}")
    public void deleteBookById(@PathVariable("bookIsbn") UUID bookIsbn) {
        bookService.deleteBookByID(bookIsbn);
    }
}
