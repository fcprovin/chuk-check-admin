package com.fcprovin.admin.web.player.service;

import com.fcprovin.admin.api.service.ApiService;
import com.fcprovin.admin.domain.Player;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.player.form.PlayerCreateForm;
import com.fcprovin.admin.web.player.form.PlayerUpdateForm;
import com.fcprovin.admin.web.player.search.PlayerSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final ApiService apiService;

    public List<Player> findAll(PlayerSearch search) {
        return null;
    }

    public Player find(Long id) {
        return null;
    }

    public Long create(PlayerCreateForm form) {
        return null;
    }

    public void update(Long id, PlayerUpdateForm form) {

    }
}
