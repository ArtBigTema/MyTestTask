package my.av.test.task.domain.internal;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import my.av.test.task.util.JsonViews;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@MappedSuperclass
@Data
@EqualsAndHashCode
@JsonView(JsonViews.Base.class)
public class IdEntity<V> implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    protected V id;
}