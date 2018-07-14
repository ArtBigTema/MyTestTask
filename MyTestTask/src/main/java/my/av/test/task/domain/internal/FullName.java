package my.av.test.task.domain.internal;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Data
@ToString
public class FullName {

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    private String lastName;
}
