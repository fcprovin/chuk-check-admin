package com.fcprovin.admin.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse<T> {

    private int code;
    private String message;
    private T result;

    private void validationSuccess() {
        if (code != HttpStatus.OK.value()) {
            throw new IllegalArgumentException(message);
        }
    }

    public T getResult() {
        validationSuccess();
        return result;
    }
}
