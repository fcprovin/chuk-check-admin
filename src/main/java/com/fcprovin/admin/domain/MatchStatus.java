package com.fcprovin.admin.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MatchStatus {

    CREATE("생성"),
    VOTE("투표"),
    ATTEND("출석"),
    FINISH("완료");

    private final String description;
}
