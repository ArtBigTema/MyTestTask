package my.av.test.task.rest.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ToString
@Data
public class BookDTO {

    @ISBN
    private String isbn;

    @NotNull
    @Positive
    private Long authorID;

    @NotNull
    @Positive
    private Long genreID;
}
