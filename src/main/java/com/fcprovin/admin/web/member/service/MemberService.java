package com.fcprovin.admin.web.member.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Member;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.member.form.MemberCreateForm;
import com.fcprovin.admin.web.member.search.MemberSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final ApiService apiService;

    public List<Member> findAll(MemberSearch search) {
        return null;
    }

    public Member find(Long id) {
        return null;
    }

    public Long create(MemberCreateForm form) {
        return null;
    }
}
