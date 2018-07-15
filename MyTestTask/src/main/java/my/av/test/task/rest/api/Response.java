package my.av.test.task.rest.api;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import my.av.test.task.util.JsonViews;

@ToString
@Data
@AllArgsConstructor
@JsonView(JsonViews.Base.class)
public class Response<T> {
    private T data;

    public static <T> Response of(T data) {
        return new Response<>(data);
    }

    public static Response ok() {
        return Response.of("ok");
    }
}
