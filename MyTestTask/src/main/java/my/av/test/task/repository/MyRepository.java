package my.av.test.task.repository;

import my.av.test.task.domain.internal.MyEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface MyRepository<T extends MyEntity<Long>> extends PagingAndSortingRepository<T, Long> {
}
