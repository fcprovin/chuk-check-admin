package com.fcprovin.admin.web.attend.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Attend;
import com.fcprovin.admin.domain.Match;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.attend.form.AttendCreateForm;
import com.fcprovin.admin.web.attend.form.AttendUpdateForm;
import com.fcprovin.admin.web.attend.search.AttendSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendService {

    private final ApiService apiService;

    public List<Attend> findAll(AttendSearch search) {
        return null;
    }

    public Attend find(Long id) {
        return null;
    }

    public Long create(AttendCreateForm form) {
        return null;
    }

    public void update(Long id, AttendUpdateForm form) {

    }
}
