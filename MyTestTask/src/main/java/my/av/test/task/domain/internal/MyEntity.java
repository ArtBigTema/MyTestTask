package my.av.test.task.domain.internal;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@MappedSuperclass
@Data
@EqualsAndHashCode
public class MyEntity<V> implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    protected V id;
}