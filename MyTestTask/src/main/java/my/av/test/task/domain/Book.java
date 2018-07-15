package my.av.test.task.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import my.av.test.task.domain.internal.StandardEntity;
import my.av.test.task.util.JsonViews;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "books")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@JsonView(JsonViews.BookView.class)
@Where(clause = "deleted=false")
public class Book extends StandardEntity {

    @NotNull
    @ISBN
    @JsonView(JsonViews.AuthorView.class)
    private String isbn;

    @NotNull
    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;
}
