package com.fcprovin.admin.api.client;

import com.fcprovin.admin.api.dto.ApiRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Order(HIGHEST_PRECEDENCE)
@Component
public class ApiClient {

    @Value("${api.host}")
    private String host;

    @Value("${api.version}")
    private String version;

    private final WebClient client;

    public ApiClient(Builder builder) {
        this.client = builder.baseUrl(host).build();
    }

    protected RequestBodySpec common(ApiRequest request) {
        return client.method(request.getMethod())
                .uri(host + prefix() + request.getUri())
                .contentType(APPLICATION_JSON);
    }

    private String prefix() {
        return "/api/" + version;
    }
}
