package my.av.test.task.service;

import my.av.test.task.domain.Genre;
import my.av.test.task.repository.GenreRepository;
import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@Transactional
public class GenreService extends CrudService<GenreRepository> {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        super(genreRepository);
        this.genreRepository = genreRepository;
    }

    @PostMapping
    public Response createGenre(GenreDTO genreDTO) {
        Genre genre = new Genre(genreDTO.getDescription());

        return Response.of(genreRepository.save(genre));
    }
}
