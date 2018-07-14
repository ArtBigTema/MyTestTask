package my.av.test.task.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import my.av.test.task.domain.internal.StandardEntity;
import my.av.test.task.util.JsonViews;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "genres")
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonView(JsonViews.GenreView.class)
public class Genre extends StandardEntity {

    @NotBlank
    @JsonView(JsonViews.BookView.class)
    private String description;
}
