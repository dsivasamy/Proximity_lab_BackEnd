package com.proximitylab.app.exception;

import com.proximitylab.app.model.ErrorMessage;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomApiException.class)
    protected ResponseEntity<Object> handleAllException(CustomApiException ex, WebRequest request) {
        ErrorMessage apiError = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorMessage apiError = new ErrorMessage(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }


    private ResponseEntity<Object> buildResponseEntity(ErrorMessage apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}

