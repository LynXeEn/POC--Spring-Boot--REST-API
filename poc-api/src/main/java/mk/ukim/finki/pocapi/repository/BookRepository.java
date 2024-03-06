package mk.ukim.finki.pocapi.repository;

import mk.ukim.finki.pocapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);
    List<Book> findBooksByAuthor(String author);
}
