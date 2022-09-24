package com.devbrunorafael.backend_pm.api.handler;

import com.devbrunorafael.backend_pm.domain.exceptions.ExceptionDetails;
import com.devbrunorafael.backend_pm.domain.exceptions.product.ProductNotFoundException;
import com.devbrunorafael.backend_pm.domain.exceptions.product.ProductNotFoundExceptionDetails;
import com.devbrunorafael.backend_pm.domain.exceptions.validation.ValidationExceptionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, 0);
        }

        var bodyException = ExceptionDetails.builder()
                .status(status.value())
                .title(ex.getCause().getMessage())
                .description(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .developerMessage(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(bodyException, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

            List<ValidationExceptionDetails.Fields> fieldsList = ex.getBindingResult().getFieldErrors()
            .stream()
            .map(error -> ValidationExceptionDetails.Fields.builder()
                    .name(error.getField())
                    .message(error.getDefaultMessage())
                    .build())
            .toList();

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Invalid fields")
                        .description("check if the fields provided are filled in properly.")
                        .timestamp(LocalDateTime.now())
                        .developerMessage(ex.getClass().getName())
                        .fields(fieldsList)
                        .build(),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ProductNotFoundExceptionDetails> handlerProductNotFoundException
            (ProductNotFoundException exception){
        return new ResponseEntity<>(
                ProductNotFoundExceptionDetails.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Product Not Found.")
                        .description(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .developerMessage(exception.getClass().getName())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

}
