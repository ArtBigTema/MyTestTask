package my.av.test.task.rest;

import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.BookDTO;
import my.av.test.task.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Response getAllBooks(@SortDefault(sort = "creationDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("{id}")
    protected Response getBookByID(@PathVariable Long id) {
        return bookService.findByID(id);
    }

    @PostMapping
    public Response createBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }
}
