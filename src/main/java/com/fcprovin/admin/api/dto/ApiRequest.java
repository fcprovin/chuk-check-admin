package com.fcprovin.admin.api.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpMethod;

import static java.util.Objects.nonNull;
import static org.springframework.web.reactive.function.BodyInserters.empty;

@Getter
@Builder
public class ApiRequest {

    private final HttpMethod method;
    private final String uri;
    private final Object body;

    public Object getBody() {
        return nonNull(body) ? body : empty();
    }
}
