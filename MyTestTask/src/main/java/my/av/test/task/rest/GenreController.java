package my.av.test.task.rest;

import my.av.test.task.rest.api.Response;
import my.av.test.task.service.GenreService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genres")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public Response getAllGenre(@SortDefault(sort = "creationDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return genreService.findAll(pageable);
    }

    @GetMapping("{id}")
    protected Response getGenreByID(@PathVariable Long id) {
        return genreService.findByID(id);
    }
}
