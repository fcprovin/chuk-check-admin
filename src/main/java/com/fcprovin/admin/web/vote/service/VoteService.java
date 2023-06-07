package com.fcprovin.admin.web.vote.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Match;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.domain.Vote;
import com.fcprovin.admin.web.vote.form.VoteCreateForm;
import com.fcprovin.admin.web.vote.form.VoteUpdateForm;
import com.fcprovin.admin.web.vote.search.VoteSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final ApiService apiService;

    public List<Vote> findAll(VoteSearch search) {
        return null;
    }

    public Vote find(Long id) {
        return null;
    }

    public Long create(VoteCreateForm form) {
        return null;
    }

    public void update(Long id, VoteUpdateForm form) {

    }
}
