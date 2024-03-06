package mk.ukim.finki.pocapi.service.impl;

import mk.ukim.finki.pocapi.model.Book;
import mk.ukim.finki.pocapi.repository.BookRepository;
import mk.ukim.finki.pocapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    public Book saveBook(String title, String author) {
        return bookRepository.save(new Book(title, author));
    }

    @Override
    public Book updateBook(Long id, String title, String author) {
        Book book = getBookById(id);
        book.setTitle(title);
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    @Override
    public Book deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
        return book;
    }
}
