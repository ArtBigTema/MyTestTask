package my.av.test.task.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Response<T> {
    private T data;

    public static <T> Response of(T data) {
        return new Response<>(data);
    }
}
