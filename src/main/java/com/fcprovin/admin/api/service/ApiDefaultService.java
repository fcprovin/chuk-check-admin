package com.fcprovin.admin.api.service;

import com.fcprovin.admin.api.client.ApiClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.token.JwtRole;
import com.fcprovin.admin.api.token.Token;
import com.fcprovin.admin.api.token.TokenCreate;
import com.fcprovin.admin.web.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Service
@RequiredArgsConstructor
public class ApiDefaultService {

    protected final ApiClient client;
    private Token token;

    @Value("${api.host}")
    private String host;

    @Value("${api.version}")
    private String version;

    @Value("${token.subject}")
    private String subject;

    @Value("${token.scope}")
    private String scope;

    protected String getToken() {
        if (isNull(token)) return (token = accessToken()).getAccessToken();
        if (token.validateAccessToken()) return token.getAccessToken();
        if (token.validateRefreshToken()) return (token = refreshToken()).getAccessToken();
        return (token = accessToken()).getAccessToken();
    }

    protected String createUrl(String uri) {
        return uriBuilder(uri).toUriString();
    }

    protected String createUrl(String uri, SearchRequest params) {
        return uriBuilder(uri).queryParams(params.convertQueries()).toUriString();
    }

    private Token accessToken() {
        return client.post(ApiRequest.<Token>builder()
                .url(createUrl("auth/access-token"))
                .body(tokenBody())
                .build())
                .getResult(Token.class);
    }

    private Token refreshToken() {
        return client.post(ApiRequest.<Token>builder()
                .url(createUrl("auth/refresh-token"))
                .headers(headers -> headers.set(AUTHORIZATION, token.getRefreshToken()))
                .build())
                .getResult(Token.class);
    }

    private TokenCreate tokenBody() {
        return new TokenCreate(Long.valueOf(subject), JwtRole.valueOf(scope));
    }

    private UriComponentsBuilder uriBuilder(String uri) {
        return fromHttpUrl(host + "/api/" + version + "/" + uri);
    }
}
