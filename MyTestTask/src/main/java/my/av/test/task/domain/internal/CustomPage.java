package my.av.test.task.domain.internal;

import com.fasterxml.jackson.annotation.JsonView;
import my.av.test.task.util.JsonViews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@JsonView(JsonViews.Base.class)
public class CustomPage<T> extends PageImpl<T> {
    private CustomPage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public static CustomPage<?> of(Page<?> page) {
        return new CustomPage<>(page.getContent(), page.getPageable(), page.getTotalElements());
    }
}
