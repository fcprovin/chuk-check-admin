package com.fcprovin.admin.api.token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JwtRole {
    ROLE_USER("사용자"), ROLE_ADMIN("관리자");

    private final String description;

}
