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
import org.hibernate.validator.internal.constraintvalidators.hv.ISBNValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import javax.validation.ValidationException;
import java.lang.reflect.Method;
import java.util.Objects;

import static my.av.test.task.util.StringConstant.*;

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

    private Response setAttributesForBook(BookDTO bookDTO, Book book) {
        Genre genre = Utils.getEntity(genreRepository, bookDTO.getGenreID(), GENRE_NOT_FOUND);
        Author author = Utils.getEntity(authorRepository, bookDTO.getAuthorID(), AUTHOR_NOT_FOUND);

        book.setIsbn(bookDTO.getIsbn());
        book.setAuthor(author);
        book.setGenre(genre);

        return Response.of(bookRepository.save(book));
    }

    public Response createBook(BookDTO bookDTO) {
        return setAttributesForBook(bookDTO, new Book());
    }

    public Response replaceBook(Long id, BookDTO authorDTO) {
        return setAttributesForBook(authorDTO, Utils.getEntity(bookRepository, id, BOOK_NOT_FOUND));
    }

    public Response patchBook(Long id, BookDTO bookDTO) {
        Book book = Utils.getEntity(bookRepository, id, BOOK_NOT_FOUND);
        String isbn = Objects.requireNonNull(bookDTO.getIsbn(), "ISBN not found.");

        Method checkChecksumISBN13 = ReflectionUtils.findMethod(ISBNValidator.class, "checkChecksumISBN13", String.class);
        Objects.requireNonNull(checkChecksumISBN13).setAccessible(true);
        Object o = ReflectionUtils.invokeMethod(checkChecksumISBN13, new ISBNValidator(), isbn.replaceAll("[^\\dX]", ""));

        if (!Boolean.parseBoolean(String.valueOf(o))) {
            throw new ValidationException("ISBN not correct.");
        }
        book.setIsbn(isbn);

        return Response.of(bookRepository.save(book));
    }
}
