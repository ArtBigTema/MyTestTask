package my.av.test.task.service;

import my.av.test.task.repository.BookRepository;
import my.av.test.task.rest.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookService extends CrudService<BookRepository> {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        super(bookRepository);
        this.bookRepository = bookRepository;
    }

}
