package com.fcprovin.admin.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;

@Getter
@Setter
public class ApiResponse<T> {

    private int code;
    private String message;
    private T result;

    public T getResult() {
        validationSuccess();
        if (result instanceof LinkedHashMap) {

        }
        return result;
    }

    private void validationSuccess() {
        if (code != HttpStatus.OK.value()) {
            throw new IllegalArgumentException(message);
        }
    }
}
