package my.av.test.task.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import my.av.test.task.domain.internal.FullName;
import my.av.test.task.domain.internal.StandardEntity;
import my.av.test.task.util.JsonViews;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "authors")
@Data
@ToString(callSuper = true, exclude = "books")
@NoArgsConstructor
@JsonView(JsonViews.AuthorView.class)
@Where(clause = "deleted=false")
public class Author extends StandardEntity {

    @NotNull
    @JsonUnwrapped
    @JsonView(JsonViews.Base.class)
    private FullName fullName;

    @NotNull
    private LocalDate birthdate;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}
