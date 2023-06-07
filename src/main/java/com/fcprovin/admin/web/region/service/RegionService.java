package com.fcprovin.admin.web.region.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Region;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.region.form.RegionCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final ApiService apiService;

    public List<Region> findAll() {
        return null;
    }

    public Region find(Long id) {
        return null;
    }

    public Long create(RegionCreateForm form) {
        return null;
    }
}
