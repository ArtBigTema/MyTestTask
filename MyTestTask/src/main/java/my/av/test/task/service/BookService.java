package my.av.test.task.service;

import my.av.test.task.domain.Author;
import my.av.test.task.domain.Book;
import my.av.test.task.domain.Genre;
import my.av.test.task.repository.AuthorRepository;
import my.av.test.task.repository.BookRepository;
import my.av.test.task.repository.GenreRepository;
import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.BookDTO;
import my.av.test.task.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookService extends CrudService<BookRepository> {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookService(BookRepository repository, BookRepository bookRepository,
                       AuthorRepository authorRepository, GenreRepository genreRepository) {
        super(repository);
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    public Response createBook(BookDTO bookDTO) {
        Genre genre = Utils.getEntity(genreRepository, bookDTO.getGenreID(), "Genre with ID: %d not found.");
        Author author = Utils.getEntity(authorRepository, bookDTO.getAuthorID(), "Author with ID: %d not found.");

        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setAuthor(author);
        book.setGenre(genre);

        return Response.of(bookRepository.save(book));
    }
}
