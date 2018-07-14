package my.av.test.task.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import my.av.test.task.domain.internal.StandardEntity;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "books")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class Book extends StandardEntity {

    @NotNull
    @ISBN
    private String isbn;

    @NotNull
    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;
}
