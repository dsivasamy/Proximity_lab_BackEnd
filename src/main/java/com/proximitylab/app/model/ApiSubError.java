package com.proximitylab.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiSubError {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiSubError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}