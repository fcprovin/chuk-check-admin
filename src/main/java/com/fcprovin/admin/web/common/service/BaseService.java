package com.fcprovin.admin.web.common.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.web.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@Service
@RequiredArgsConstructor
public abstract class BaseService {

    protected final ApiServiceClient serviceClient;

    protected abstract String uri();

    protected String uri(Long id) {
        return fromPath(String.join("/", uri(), "{id}")).buildAndExpand(id).toUriString();
    }

    protected String uri(SearchRequest searchRequest) {
        return fromPath(uri()).queryParams(searchRequest.convertQueries()).encode(UTF_8).toUriString();
    }
}
