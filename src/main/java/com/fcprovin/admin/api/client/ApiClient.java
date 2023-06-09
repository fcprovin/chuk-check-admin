package com.fcprovin.admin.api.client;

import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class ApiClient {

    private final WebClient client;

    public ApiClient(WebClient.Builder builder) {
        this.client = builder.build();
    }

    public <T> ApiResponse<T> get(ApiRequest<T> request) {
        return common(request, GET)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<T>>() {})
                .block();
    }

    public <T> ApiResponse<T> post(ApiRequest<T> request) {
        return common(request, POST)
                .body(fromValue(request.getBody()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<T>>() {})
                .block();
    }

    public <T> ApiResponse<T> put(ApiRequest<T> request) {
        return common(request, PUT)
                .body(fromValue(request.getBody()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<T>>() {})
                .block();
    }

    private <T> RequestBodySpec common(ApiRequest<T> request, HttpMethod method) {
        return client.method(method)
                .uri(request.getUrl())
                .contentType(APPLICATION_JSON)
                .headers(request.getHeaders());
    }
}
