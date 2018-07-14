package my.av.test.task.rest.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotNull;

@ToString
@Data
public class BookDTO {

    @ISBN
    private String isbn;

    @NotNull
    private Long authorID;

    @NotNull
    private Long genreID;
}
