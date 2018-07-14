package my.av.test.task.repository;

import my.av.test.task.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MyRepository<Book> {
}
