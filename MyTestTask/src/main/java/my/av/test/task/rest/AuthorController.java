package my.av.test.task.rest;

import com.fasterxml.jackson.annotation.JsonView;
import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.AuthorDTO;
import my.av.test.task.rest.dto.BookDTO;
import my.av.test.task.service.AuthorService;
import my.av.test.task.util.JsonViews;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @JsonView(JsonViews.AuthorView.class)
    public Response getAllAuthors(@SortDefault(sort = "creationDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return authorService.findAll(pageable);
    }

    @GetMapping("{id}")
    @JsonView(JsonViews.AuthorView.class)
    public Response getAuthorByID(@PathVariable Long id) {
        return authorService.findByID(id);
    }

    @PostMapping
    @JsonView(JsonViews.AuthorView.class)
    public Response createAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }

    @PutMapping("{id}")
    @JsonView(JsonViews.AuthorView.class)
    public Response modifyAuthor(@PathVariable Long id,
                                 @RequestBody @Valid AuthorDTO authorDTO) {
        return authorService.replaceAuthor(id, authorDTO);
    }

    @PatchMapping("{id}")
    @JsonView(JsonViews.AuthorView.class)
    public Response patchAuthor(@PathVariable Long id,
                                @RequestBody AuthorDTO authorDTO) {
        return authorService.patchAuthor(id, authorDTO);
    }

    @DeleteMapping("{id}")
    public Response deleteAuthor(@PathVariable Long id) {
        return authorService.delete(id);
    }
}
