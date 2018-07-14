package my.av.test.task.rest;

import my.av.test.task.rest.api.Response;
import my.av.test.task.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
