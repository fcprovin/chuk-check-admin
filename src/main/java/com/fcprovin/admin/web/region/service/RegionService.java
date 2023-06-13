package com.fcprovin.admin.web.region.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.region.domain.Region;
import com.fcprovin.admin.web.region.form.RegionCreateForm;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Service
public class RegionService extends BaseService {

    public RegionService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/region";
    }

    public List<Region> list() {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri())
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Region>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public void add(RegionCreateForm form) {
        serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Region>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
