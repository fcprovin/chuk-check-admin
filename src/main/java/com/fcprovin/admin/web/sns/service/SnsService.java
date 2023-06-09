package com.fcprovin.admin.web.sns.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.sns.form.SnsCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SnsService {

    private final ApiService apiService;

    public List<Sns> findAll() {
        return null;
    }

    public Sns find(Long id) {
        return null;
    }

    public Long create(SnsCreateForm form) {
        return null;
    }
}
