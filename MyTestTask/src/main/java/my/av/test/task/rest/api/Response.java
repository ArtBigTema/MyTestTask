package my.av.test.task.rest.api;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import my.av.test.task.util.JsonViews;
import org.springframework.data.util.Pair;

@Slf4j
@ToString
@Data
@AllArgsConstructor
@JsonView(JsonViews.Base.class)
public class Response<T> {
    private T data;

    public static <T> Response of(T data) {
        log.info("Response: ", data);
        return new Response<>(data);
    }

    public static <T extends Throwable> Response ex(T exception) {
        return ex(exception.getMessage(), exception);
    }

    public static <T extends Throwable> Response ex(String msg, T exception) {
        return new Response<>(Pair.of(msg, exception.getStackTrace()));//fixme mb stackTrace
    }

    public static Response ok() {
        return Response.of("ok");
    }
}
