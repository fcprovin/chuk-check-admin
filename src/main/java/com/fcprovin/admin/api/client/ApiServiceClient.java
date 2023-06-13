package com.fcprovin.admin.api.client;

import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.repository.ApiTokenRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class ApiServiceClient extends ApiClient {

    private final ApiTokenRepository tokenRepository;

    public ApiServiceClient(Builder builder, ApiTokenRepository tokenRepository) {
        super(builder);
        this.tokenRepository = tokenRepository;
    }

    public ResponseSpec execute(ApiRequest request) {
        return common(request)
                .header(AUTHORIZATION, tokenRepository.getAccessToken())
                .bodyValue(request.getBody())
                .retrieve();
    }
}
