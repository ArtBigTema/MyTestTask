package my.av.test.task.repository;

import my.av.test.task.domain.internal.MyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface MyRepository<T extends MyEntity<Long>> extends CrudRepository<T, Long> {
}
