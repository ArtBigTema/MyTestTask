package my.av.test.task.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import my.av.test.task.domain.internal.StandardEntity;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "books")
@Data
@ToString(callSuper = true)
public class Book extends StandardEntity {

    @NotNull
    @ISBN
    private String isbn;

    @NotNull
//    @ManyToOne
    private String author;
    @NotNull
//    @ManyToOne
    private String genre;
}
