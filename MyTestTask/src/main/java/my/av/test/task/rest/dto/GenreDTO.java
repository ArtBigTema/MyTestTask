package my.av.test.task.rest.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Data
public class GenreDTO {

    @NotBlank
    private String description;
}
