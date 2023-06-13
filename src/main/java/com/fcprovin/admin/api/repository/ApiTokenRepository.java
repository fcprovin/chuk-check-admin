package com.fcprovin.admin.api.repository;

import com.fcprovin.admin.api.client.ApiTokenClient;
import com.fcprovin.admin.api.vo.token.JwtRole;
import com.fcprovin.admin.api.vo.token.Token;
import com.fcprovin.admin.api.vo.token.TokenCreate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import static java.util.Objects.isNull;

@Repository
public class ApiTokenRepository {

    @Value("${token.subject}")
    private Long subject;

    @Value("${token.scope}")
    private String scope;

    private Token token;

    private final ApiTokenClient tokenClient;

    public ApiTokenRepository(ApiTokenClient tokenClient) {
        this.tokenClient = tokenClient;
    }

    public String getAccessToken() {
        validate();
        return token.getAccessToken();
    }

    public void validate() {
        if (isNull(token) || (!token.validateAccessToken() && !token.validateRefreshToken())) access();
        else if (token.validateRefreshToken()) refresh();
    }

    private void access() {
        token = tokenClient.accessToken(tokenCreateBody());
    }

    private void refresh() {
        token = tokenClient.refreshToken(token.getAccessToken());
    }

    private TokenCreate tokenCreateBody() {
        return new TokenCreate(subject, JwtRole.valueOf(scope));
    }
}
