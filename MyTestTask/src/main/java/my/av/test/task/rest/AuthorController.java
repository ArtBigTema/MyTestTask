package my.av.test.task.rest;

import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.AuthorDTO;
import my.av.test.task.service.AuthorService;
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
    public Response getAllAuthors(@SortDefault(sort = "creationDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return authorService.findAll(pageable);
    }

    @GetMapping("{id}")
    public Response getAuthorByID(@PathVariable Long id) {
        return authorService.findByID(id);
    }

    @PostMapping
    public Response createAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }
}
