package my.av.test.task.service;

import my.av.test.task.domain.Genre;
import my.av.test.task.repository.GenreRepository;
import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.GenreDTO;
import my.av.test.task.util.StringConstant;
import my.av.test.task.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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

    public Response replaceGenre(Long id, GenreDTO genreDTO) {
        Genre genre = Utils.getEntity(genreRepository, id, StringConstant.GENRE_NOT_FOUND);

        String desc = Optional.ofNullable(genreDTO.getDescription())
                .filter(StringUtils::isNotBlank)
                .orElseThrow(() -> new RuntimeException("Description must be exist for patch."));
        genre.setDescription(desc);

        return Response.of(genreRepository.save(genre));
    }
}
