package my.av.test.task.domain.internal;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class StandardEntity extends MyEntity<Long> {

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Setter(AccessLevel.NONE)
    protected LocalDateTime creationDate;

    @NotNull
    protected boolean deleted;

    @NotNull
    @LastModifiedDate
    @Setter(AccessLevel.NONE)
    protected LocalDateTime modificationDate;
}
