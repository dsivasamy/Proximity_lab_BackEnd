package com.proximitylab.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorMessage {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ApiSubError> subErrors;

    private ErrorMessage() {
        timestamp = LocalDateTime.now();
    }

    public ErrorMessage(HttpStatus status) {
        this();
        this.status = status;
    }

    public ErrorMessage(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ErrorMessage(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    private void addSubError(ApiSubError subError) {
        if (subErrors == null) {
            List<ApiSubError> subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(fieldError -> addSubError(new ApiSubError(fieldError.getObjectName(), fieldError.getField(),
                fieldError.getRejectedValue(), fieldError.getDefaultMessage())));
    }


    public void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(globalError -> addSubError(
                new ApiSubError(globalError.getObjectName(), globalError.getDefaultMessage())));
    }

}
