package com.fcprovin.admin.web.stadium.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.stadium.domain.Stadium;
import com.fcprovin.admin.web.stadium.form.StadiumCreateForm;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Service
public class StadiumService extends BaseService {

    public StadiumService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/stadium";
    }

    public List<Stadium> list() {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri())
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Stadium>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Stadium detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Stadium>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Stadium add(StadiumCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Stadium>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
