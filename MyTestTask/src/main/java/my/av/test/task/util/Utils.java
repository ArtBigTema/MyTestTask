package my.av.test.task.util;

import lombok.experimental.UtilityClass;
import my.av.test.task.domain.internal.MyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.function.Supplier;

import static java.lang.String.format;

@lombok.extern.slf4j.Slf4j
@UtilityClass
public class Utils {

    public <E extends MyEntity<Long>> E getEntity(CrudRepository<E, Long> repository, Long id, String msg) {
        return repository.findById(id).orElseThrow(entityNotFound(format(msg, id)));
    }

    public Supplier<RuntimeException> entityNotFound(String message) {
        return () -> {
            log.warn("{}", message);
            return new RuntimeException(message);
        };
    }
}
