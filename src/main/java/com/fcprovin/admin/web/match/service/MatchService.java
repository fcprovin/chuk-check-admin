package com.fcprovin.admin.web.match.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.match.domain.Match;
import com.fcprovin.admin.web.match.form.MatchCreateForm;
import com.fcprovin.admin.web.match.form.MatchUpdateForm;
import com.fcprovin.admin.web.match.search.MatchSearch;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Service
public class MatchService extends BaseService {

    public MatchService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/match";
    }

    public List<Match> list(MatchSearch search) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(search))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Match>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Match detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Match>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Match add(MatchCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Match>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public void modify(Long id, MatchUpdateForm form) {
        serviceClient.execute(ApiRequest.builder()
                        .method(PUT)
                        .uri(uri(id))
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Match>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
