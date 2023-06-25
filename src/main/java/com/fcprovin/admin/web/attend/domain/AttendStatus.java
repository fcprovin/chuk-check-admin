package com.fcprovin.admin.web.attend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AttendStatus {

    ATTEND("출석"),
    LATE("지각"),
    ABSENT("결석"),
    REASON("사유");

    private final String description;
}
