package com.fcprovin.admin.api.client;

import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.api.vo.token.Token;
import com.fcprovin.admin.api.vo.token.TokenCreate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.POST;

@Component
public class ApiTokenClient extends ApiClient {

    public ApiTokenClient(Builder builder) {
        super(builder);
    }

    public Token accessToken(TokenCreate tokenCreate) {
        return common(ApiRequest.builder()
                    .method(POST)
                    .uri("/auth/access-token")
                    .build())
                .bodyValue(tokenCreate)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Token>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Token refreshToken(String accessToken) {
        return common(ApiRequest.builder()
                    .method(POST)
                    .uri("/auth/refresh-token")
                    .build())
                .header(AUTHORIZATION, accessToken)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Token>>(){})
                .map(ApiResponse::getResult)
                .block();
    }
}
