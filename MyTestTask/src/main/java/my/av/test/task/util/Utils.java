package my.av.test.task.util;

import lombok.experimental.UtilityClass;
import my.av.test.task.domain.internal.IdEntity;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;
import java.util.function.Supplier;

import static java.lang.String.format;

@lombok.extern.slf4j.Slf4j
@UtilityClass
public class Utils {

    public <E extends IdEntity<Long>> E getEntity(CrudRepository<E, Long> repository, Long id, String msg) {
        return repository.findById(id).orElseThrow(entityNotFound(format(msg, id)));
    }

    public Supplier<EntityNotFoundException> entityNotFound(String message) {
        return () -> {
            log.warn("{}", message);
            return new EntityNotFoundException(message);
        };
    }
}
