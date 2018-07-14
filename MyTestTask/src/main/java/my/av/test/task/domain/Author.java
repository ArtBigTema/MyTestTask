package my.av.test.task.domain;

import lombok.Data;
import lombok.ToString;
import my.av.test.task.domain.internal.FullName;
import my.av.test.task.domain.internal.StandardEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name = "authors")
@Data
@ToString(callSuper = true)
public class Author extends StandardEntity {

    @NotNull
    private FullName fullName;

    @NotNull
    private LocalDate birthdate;
}
