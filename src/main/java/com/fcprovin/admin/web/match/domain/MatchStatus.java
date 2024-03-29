package com.fcprovin.admin.web.match.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MatchStatus {

    CREATE("생성"),
    VOTE("투표"),
    MATCH("매치"),
    ATTEND("출석"),
    FINISH("완료");

    private final String description;
}
