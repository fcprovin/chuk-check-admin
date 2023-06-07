package com.fcprovin.admin.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BaseStatus {

    WAIT("대기"),
    APPROVE("승인"),
    EXIT("탈퇴");

    private final String description;
}
