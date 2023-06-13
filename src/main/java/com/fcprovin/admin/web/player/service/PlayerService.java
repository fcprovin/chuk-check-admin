package com.fcprovin.admin.web.player.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.player.domain.Player;
import com.fcprovin.admin.web.player.form.PlayerCreateForm;
import com.fcprovin.admin.web.player.form.PlayerUpdateForm;
import com.fcprovin.admin.web.player.search.PlayerSearch;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Service
public class PlayerService extends BaseService {

    public PlayerService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/player";
    }

    public List<Player> list(PlayerSearch search) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(search))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Player>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Player detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Player>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Player add(PlayerCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Player>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public void modify(Long id, PlayerUpdateForm form) {
        serviceClient.execute(ApiRequest.builder()
                        .method(PUT)
                        .uri(uri(id))
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Player>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
