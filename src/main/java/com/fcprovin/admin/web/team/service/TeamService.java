package com.fcprovin.admin.web.team.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.team.domain.Team;
import com.fcprovin.admin.web.team.form.TeamCreateForm;
import com.fcprovin.admin.web.team.form.TeamUpdateForm;
import com.fcprovin.admin.web.team.search.TeamSearch;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Service
public class TeamService extends BaseService {

    public TeamService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/team";
    }

    public List<Team> list(TeamSearch search) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(search))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Team>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Team detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Team>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Team add(TeamCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Team>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public void modify(Long id, TeamUpdateForm form) {
        serviceClient.execute(ApiRequest.builder()
                        .method(PUT)
                        .uri(uri(id))
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Team>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
