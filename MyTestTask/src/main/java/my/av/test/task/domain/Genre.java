package my.av.test.task.domain;

import lombok.ToString;
import my.av.test.task.domain.internal.StandardEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity(name = "genres")
@ToString(callSuper = true)
public class Genre extends StandardEntity {

    @NotBlank
    private String description;
}
