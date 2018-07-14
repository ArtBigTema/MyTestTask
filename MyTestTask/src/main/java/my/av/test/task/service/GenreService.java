package my.av.test.task.service;

import my.av.test.task.domain.Genre;
import my.av.test.task.repository.GenreRepository;
import my.av.test.task.rest.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends CrudService<GenreRepository> {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        super(genreRepository);
        this.genreRepository = genreRepository;
    }
}
