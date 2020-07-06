package org.soyphea;

import feign.FeignException;
import org.soyphea.exception.BookClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { BookClientException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse badRequest(Exception ex) {
        return ApiResponse.fail(ex.getMessage());
    }

    @ExceptionHandler(value = { FeignException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse feignClient(Exception ex) {
        return ApiResponse.fail("Can not connect to server.");
    }
}
