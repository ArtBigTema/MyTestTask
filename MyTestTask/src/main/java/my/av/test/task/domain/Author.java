package my.av.test.task.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import my.av.test.task.domain.internal.FullName;
import my.av.test.task.domain.internal.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "authors")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class Author extends StandardEntity {

    @NotNull
    @JsonUnwrapped
    private FullName fullName;

    @NotNull
    private LocalDate birthdate;

    @OneToMany
    private List<Book> books;
}
