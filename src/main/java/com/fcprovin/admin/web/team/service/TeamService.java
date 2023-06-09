package com.fcprovin.admin.web.team.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.domain.Team;
import com.fcprovin.admin.web.team.form.TeamCreateForm;
import com.fcprovin.admin.web.team.form.TeamUpdateForm;
import com.fcprovin.admin.web.team.search.TeamSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final ApiService apiService;

    public List<Team> findAll(TeamSearch search) {
        return null;
    }

    public Team find(Long id) {
        return null;
    }

    public Long create(TeamCreateForm form) {
        return null;
    }

    public void update(Long id, TeamUpdateForm form) {

    }
}
