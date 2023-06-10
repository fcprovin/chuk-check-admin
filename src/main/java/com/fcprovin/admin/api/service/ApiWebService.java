package com.fcprovin.admin.api.service;

import com.fcprovin.admin.api.client.ApiClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.SearchRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class ApiWebService extends ApiDefaultService {

    public ApiWebService(ApiClient client) {
        super(client);
    }

    public <T> ApiResponse<List<T>> findAll(String uri, SearchRequest search) {
        return client.get(ApiRequest.<List<T>>builder()
                .url(createUrl(uri, search))
                .headers(this::setToken)
                .build());
    }

    public <T> ApiResponse<List<T>> findAll(String uri) {
        return client.get(ApiRequest.<List<T>>builder()
                .url(createUrl(uri))
                .headers(this::setToken)
                .build());
    }

    public <T> ApiResponse<T> find(String uri) {
        return client.get(ApiRequest.<T>builder()
                .url(createUrl(uri))
                .headers(this::setToken)
                .build());
    }

    public <T> ApiResponse<T> create(String uri, Object body) {
        return client.post(ApiRequest.<T>builder()
                .url(createUrl(uri))
                .headers(this::setToken)
                .body(body)
                .build());
    }

    public <T> ApiResponse<T> update(String uri, Object body) {
        return client.put(ApiRequest.<T>builder()
                .url(createUrl(uri))
                .headers(this::setToken)
                .body(body)
                .build());
    }

    private void setToken(HttpHeaders headers) {
        headers.set(AUTHORIZATION, getToken());
    }
}
