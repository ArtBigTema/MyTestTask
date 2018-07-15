package my.av.test.task.rest;

import lombok.extern.slf4j.Slf4j;
import my.av.test.task.rest.api.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.Objects;
import java.util.Optional;


@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleException(Throwable t) {

        Throwable cause = Optional.ofNullable(t.getCause()).orElse(t);

        if (EntityNotFoundException.class.isInstance(cause)) {
            return handleException(EntityNotFoundException.class.cast(cause));
        }
        if (ValidationException.class.isInstance(cause)) {
            return handleException(ValidationException.class.cast(cause));
        }
        if (MethodArgumentNotValidException.class.isInstance(cause)) {
            return handleException(MethodArgumentNotValidException.class.cast(cause));
        }

        return handleThrowable(t);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Response handleException(EntityNotFoundException notFoundException) {
        log.error("Object not found", notFoundException);
        return Response.ex(notFoundException);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Response handleException(ValidationException exception) {
        log.error("Validation exception", exception);
        return Response.ex(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Response handleException(MethodArgumentNotValidException exception) {
        log.error("Validation exception", exception);
        FieldError fieldError = exception.getBindingResult().getFieldError();
        String msg = StringUtils.join("Field: ", Objects.requireNonNull(fieldError).getField(),
                " ", fieldError.getDefaultMessage(), ", but it: ", fieldError.getRejectedValue());
        return Response.ex(msg, exception);
    }

    private Response handleThrowable(Throwable t) {
        log.error("Error processing request", t);
        return Response.ex(t);
    }
}
