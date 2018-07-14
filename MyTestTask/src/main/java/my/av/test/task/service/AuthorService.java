package my.av.test.task.service;

import my.av.test.task.repository.AuthorRepository;
import my.av.test.task.rest.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends CrudService<AuthorRepository> {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
        this.authorRepository = authorRepository;
    }
}
