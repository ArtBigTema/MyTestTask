package my.av.test.task.service;

import my.av.test.task.domain.Author;
import my.av.test.task.domain.internal.FullName;
import my.av.test.task.repository.AuthorRepository;
import my.av.test.task.rest.api.Response;
import my.av.test.task.rest.dto.AuthorDTO;
import my.av.test.task.util.StringConstant;
import my.av.test.task.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class AuthorService extends CrudService<AuthorRepository> {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
        this.authorRepository = authorRepository;
    }

    private Author setAttributesForAuthor(AuthorDTO authorDTO, Author author) {
        FullName fullName = new FullName();
        BeanUtils.copyProperties(authorDTO, fullName);

        author.setFullName(fullName);
        author.setBirthdate(authorDTO.getBirthdate());

        return authorRepository.save(author);
    }

    public Response createAuthor(AuthorDTO authorDTO) {
        Author author = setAttributesForAuthor(authorDTO, new Author());
        author.setBooks(Collections.emptyList());

        return Response.of(authorRepository.save(author));
    }

    public Response replaceAuthor(Long id, AuthorDTO authorDTO) {
        return Response.of(setAttributesForAuthor(
                authorDTO, Utils.getEntity(authorRepository, id, StringConstant.AUTHOR_NOT_FOUND)));
    }

    public Response patchAuthor(Long id, AuthorDTO authorDTO) {
        Author author = Utils.getEntity(authorRepository, id, StringConstant.AUTHOR_NOT_FOUND);

        Optional.ofNullable(authorDTO.getBirthdate())
                .ifPresent(author::setBirthdate);
        BeanUtils.copyProperties(authorDTO, author.getFullName());

        return Response.of(authorRepository.save(author));
    }
}
