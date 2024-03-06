package mk.ukim.finki.pocapi.service;

import mk.ukim.finki.pocapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(Long id);
    List<Book> getBooksByAuthor(String author);
    Book saveBook(String title, String author);
    Book updateBook(Long id,String title, String author);
    Book deleteBook(Long id);
}
