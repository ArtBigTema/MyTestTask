package my.av.test.task.rest.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@ToString
@Data
public class GenreDTO {
    @NotBlank
    private String description;
}
