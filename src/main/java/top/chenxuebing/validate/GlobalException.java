package top.chenxuebing.validate;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chen.xuebing
 * @date 2022/7/5 16:02
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public String exception(Exception ex) {
        if (ex instanceof ConstraintViolationException) {
            return ex.getMessage();
        }

        if (ex instanceof MethodArgumentNotValidException) {
            return ((MethodArgumentNotValidException) ex).getAllErrors()
                       .stream()
                       .map(x -> String.format("%s %s", x.getCodes()[0], x.getDefaultMessage()))
                       .collect(Collectors.joining("\n"));
        }

        return "系统内部错误";
    }
}
