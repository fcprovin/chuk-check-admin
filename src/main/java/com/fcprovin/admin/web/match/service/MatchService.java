package com.fcprovin.admin.web.match.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Match;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.match.form.MatchCreateForm;
import com.fcprovin.admin.web.match.form.MatchUpdateForm;
import com.fcprovin.admin.web.match.search.MatchSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final ApiService apiService;

    public List<Match> findAll(MatchSearch search) {
        return null;
    }

    public Match find(Long id) {
        return null;
    }

    public Long create(MatchCreateForm form) {
        return null;
    }

    public void update(Long id, MatchUpdateForm form) {

    }
}
