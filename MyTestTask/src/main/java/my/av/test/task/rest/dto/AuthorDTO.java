package my.av.test.task.rest.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
@Data
public class AuthorDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    private String lastName;

    @NotNull
    private LocalDate birthdate;

}
