package com.fcprovin.admin.web.stadium.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Stadium;
import com.fcprovin.admin.web.stadium.form.StadiumCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StadiumService {

    private final ApiService apiService;

    public List<Stadium> findAll() {
        return null;
    }

    public Stadium find(Long id) {
        return null;
    }

    public Long create(StadiumCreateForm form) {
        return null;
    }
}
