package my.av.test.task.rest;

import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.GenreDTO;
import my.av.test.task.service.GenreService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Response getGenreByID(@PathVariable Long id) {
        return genreService.findByID(id);
    }

    @PostMapping
    public Response createGenre(@RequestBody @Valid GenreDTO genreDTO) {
        return genreService.createGenre(genreDTO);
    }
}
