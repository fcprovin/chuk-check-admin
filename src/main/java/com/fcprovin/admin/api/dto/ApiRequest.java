package com.fcprovin.admin.api.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;

import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static org.springframework.web.reactive.function.BodyInserters.empty;

@Getter
@Builder
public class ApiRequest<T> {

    private final String url;
    private final Consumer<HttpHeaders> headers;
    private final Object body;

    private ApiResponse<T> response;

    public Object getBody() {
        return nonNull(body) ? body : empty();
    }

    public Consumer<HttpHeaders> getHeaders() {
        return nonNull(headers) ? headers : headers -> new HttpHeaders();
    }
}
