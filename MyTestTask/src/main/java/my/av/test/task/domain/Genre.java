package my.av.test.task.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import my.av.test.task.domain.internal.StandardEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "genres")
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Genre extends StandardEntity {

    @NotBlank
    private String description;
}
