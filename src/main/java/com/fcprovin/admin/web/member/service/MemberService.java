package com.fcprovin.admin.web.member.service;

import com.fcprovin.admin.api.client.ApiServiceClient;
import com.fcprovin.admin.api.dto.ApiRequest;
import com.fcprovin.admin.api.dto.ApiResponse;
import com.fcprovin.admin.web.common.service.BaseService;
import com.fcprovin.admin.web.member.domain.Member;
import com.fcprovin.admin.web.member.form.MemberCreateForm;
import com.fcprovin.admin.web.member.search.MemberSearch;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Service
public class MemberService extends BaseService {

    public MemberService(ApiServiceClient serviceClient) {
        super(serviceClient);
    }

    @Override
    protected String uri() {
        return "/member";
    }

    public List<Member> list(MemberSearch search) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(search))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<Member>>>(){})
                .map(ApiResponse::getResult)
                .block();
    }

    public Member detail(Long id) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(GET)
                        .uri(uri(id))
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Member>>() {})
                .map(ApiResponse::getResult)
                .block();
    }

    public Member add(MemberCreateForm form) {
        return serviceClient.execute(ApiRequest.builder()
                        .method(POST)
                        .uri(uri())
                        .body(form)
                        .build())
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Member>>() {})
                .map(ApiResponse::getResult)
                .block();
    }
}
