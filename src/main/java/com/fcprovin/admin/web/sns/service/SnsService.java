package com.fcprovin.admin.web.sns.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.sns.domain.Sns;
import com.fcprovin.admin.web.sns.form.SnsCreateForm;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Service
public class SnsService extends BaseService {

    public SnsService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/sns";
    }

    public List<Sns> list() {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri())
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Sns>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Sns detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Sns>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Sns add(SnsCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Sns>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
