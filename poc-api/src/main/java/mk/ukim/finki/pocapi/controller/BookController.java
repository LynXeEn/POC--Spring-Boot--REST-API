package mk.ukim.finki.pocapi.controller;

import mk.ukim.finki.pocapi.model.Book;
import mk.ukim.finki.pocapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poc/api")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/byAuthor")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam String author){
        try {
            List<Book> books = bookService.getBooksByAuthor(author);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public Book saveBook(@RequestParam String title, @RequestParam String author){
        return bookService.saveBook(title, author);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestParam String title, @RequestParam String author){
        return bookService.updateBook(id,title, author);
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}
