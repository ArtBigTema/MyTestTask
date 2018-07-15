package my.av.test.task.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import my.av.test.task.domain.internal.StandardEntity;
import my.av.test.task.util.JsonViews;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "genres")
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonView(JsonViews.GenreView.class)
@Where(clause = "deleted=false")
public class Genre extends StandardEntity {

    @NotBlank
    @JsonView(JsonViews.BookView.class)
    private String description;
}
