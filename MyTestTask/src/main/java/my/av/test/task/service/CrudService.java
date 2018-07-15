package my.av.test.task.service;

import my.av.test.task.domain.internal.CustomPage;
import my.av.test.task.domain.internal.StandardEntity;
import my.av.test.task.repository.MyRepository;
import my.av.test.task.rest.api.Response;
import my.av.test.task.util.StringConstant;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

public abstract class CrudService<REP extends MyRepository<? extends StandardEntity>> {
    private REP repository;

    CrudService(REP repository) {
        this.repository = repository;
    }

    private StandardEntity getEntity(Long id) {
        return repository.findById(id).orElseThrow(getExceptionSupplier(id));
    }

    public Response findAll(Pageable pageable) {
        return Response.of(CustomPage.of(repository.findAll(pageable)));
    }

    public Response findByID(Long id) {
        return Response.of(getEntity(id));
    }

    private Supplier<RuntimeException> getExceptionSupplier(Long id) {
        return () -> new RuntimeException(String.format(StringConstant.ENTITY_NOT_FOUND, id));
    }

    @Transactional
    public Response delete(Long id) {
        repository.softDelete(id);
        return Response.ok();
    }
}
