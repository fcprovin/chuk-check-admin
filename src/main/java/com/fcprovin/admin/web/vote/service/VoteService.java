package com.fcprovin.admin.web.vote.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.vote.domain.Vote;
import com.fcprovin.admin.web.vote.form.VoteCreateForm;
import com.fcprovin.admin.web.vote.form.VoteUpdateForm;
import com.fcprovin.admin.web.vote.search.VoteSearch;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Service
public class VoteService extends BaseService {

    public VoteService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/vote";
    }

    public List<Vote> list() {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri())
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Vote>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public List<Vote> list(VoteSearch search) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(search))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Vote>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Vote detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Vote>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Vote add(VoteCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Vote>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public void modify(Long id, VoteUpdateForm form) {
        serviceClient.execute(ApiRequest.builder()
                        .method(PUT)
                        .uri(uri(id))
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Vote>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
