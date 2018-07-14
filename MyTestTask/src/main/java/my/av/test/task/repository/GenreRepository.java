package my.av.test.task.repository;

import my.av.test.task.domain.Genre;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends MyRepository<Genre> {
}
