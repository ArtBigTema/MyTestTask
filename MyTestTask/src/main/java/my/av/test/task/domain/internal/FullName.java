package my.av.test.task.domain.internal;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import my.av.test.task.util.JsonViews;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Embeddable
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@JsonView(JsonViews.Base.class)
public class FullName implements Serializable {

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    private String lastName;

    public String getFullName() {
        return Stream.of(secondName, firstName, lastName)
                .filter(Objects::nonNull).collect(Collectors.joining(" "));
    }
}
