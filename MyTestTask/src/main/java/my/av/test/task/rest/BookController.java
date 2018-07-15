package my.av.test.task.rest;

import com.fasterxml.jackson.annotation.JsonView;
import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.BookDTO;
import my.av.test.task.service.BookService;
import my.av.test.task.util.JsonViews;
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
    @JsonView(JsonViews.BookView.class)
    public Response getAllBooks(@SortDefault(sort = "creationDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("{id}")
    @JsonView(JsonViews.BookView.class)
    public Response getBookByID(@PathVariable Long id) {
        return bookService.findByID(id);
    }

    @PostMapping
    @JsonView(JsonViews.BookView.class)
    public Response createBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @PutMapping("{id}")
    @JsonView(JsonViews.BookView.class)
    public Response modifyBook(@PathVariable Long id,
                               @RequestBody @Valid BookDTO bookDTO) {
        return bookService.replaceBook(id, bookDTO);
    }

    @PatchMapping("{id}")
    @JsonView(JsonViews.BookView.class)
    public Response patchBook(@PathVariable Long id,
                              @RequestBody BookDTO bookDTO) {
        return bookService.patchBook(id, bookDTO);
    }

    @DeleteMapping("{id}")
    public Response deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }
}
