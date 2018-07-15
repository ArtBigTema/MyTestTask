package my.av.test.task.repository;

import my.av.test.task.domain.internal.IdEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface MyRepository<T extends IdEntity<Long>> extends PagingAndSortingRepository<T, Long> {

    @Query("update #{#entityName} e set e.deleted=true where e.id=?1")
    @Modifying
    void softDelete(Long id);
}
