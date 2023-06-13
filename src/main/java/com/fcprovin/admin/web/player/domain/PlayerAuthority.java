package com.fcprovin.admin.web.player.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PlayerAuthority {

    GENERAL("일반"),
    MANAGER("임원"),
    LEADER("리더");

    private final String description;
}
