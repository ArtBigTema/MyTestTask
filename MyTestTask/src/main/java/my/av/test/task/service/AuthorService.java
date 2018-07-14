package my.av.test.task.service;

import my.av.test.task.domain.Author;
import my.av.test.task.domain.internal.FullName;
import my.av.test.task.repository.AuthorRepository;
import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.AuthorDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService extends CrudService<AuthorRepository> {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
        this.authorRepository = authorRepository;
    }


    public Response createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();

        FullName fullName = new FullName();
        BeanUtils.copyProperties(authorDTO, fullName);

        author.setFullName(fullName);
        author.setBirthdate(authorDTO.getBirthdate());

        return Response.of(authorRepository.save(author));
    }
}
