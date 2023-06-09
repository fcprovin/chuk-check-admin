package com.fcprovin.admin.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.MultiValueMap;

public interface SearchRequest {

    default MultiValueMap<String, String> convertQueries() {
        return new ObjectMapper().convertValue(this, new TypeReference<>() {
        });
    }
}
