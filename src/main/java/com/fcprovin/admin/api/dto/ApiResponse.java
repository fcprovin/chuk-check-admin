package com.fcprovin.admin.api.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse<T> {

    private int code;
    private String message;
    private T result;

    public T getResult() {
        validationSuccess();
        return result;
    }

    private void validationSuccess() {
        if (code != HttpStatus.OK.value()) {
            throw new IllegalArgumentException(message);
        }
    }

    public T getResult(Class<T> type) {
        result = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .convertValue(result, type);
        return getResult();
    }
}
