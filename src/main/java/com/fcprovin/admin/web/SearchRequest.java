package com.fcprovin.admin.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public interface SearchRequest {

    default MultiValueMap<String, String> convertQueries() {
        Map<String, String> map = new ObjectMapper().convertValue(this, new TypeReference<>() {});

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.setAll(map);

        return params;
    }
}
