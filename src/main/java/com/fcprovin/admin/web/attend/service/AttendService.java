package com.fcprovin.admin.web.attend.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.attend.domain.Attend;
import com.fcprovin.admin.web.attend.form.AttendCreateForm;
import com.fcprovin.admin.web.attend.form.AttendUpdateForm;
import com.fcprovin.admin.web.attend.search.AttendSearch;
import com.fcprovin.admin.web.common.service.BaseService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Service
public class AttendService extends BaseService {

    public AttendService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/attend";
    }

    public List<Attend> list(AttendSearch search) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(search))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Attend>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Attend detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Attend>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Attend add(AttendCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Attend>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public void modify(Long id, AttendUpdateForm form) {
        serviceClient.execute(ApiRequest.builder()
                    .method(PUT)
                    .uri(uri(id))
                    .body(form)
                    .build())
            .bodyToMono(new ParameterizedTypeReference<ApiResponse<Attend>>() {})
            .map(ApiResponse::getResult)
            .block();
    }
}
