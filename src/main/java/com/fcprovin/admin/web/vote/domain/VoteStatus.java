package com.fcprovin.admin.web.vote.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VoteStatus {

    WAIT("미참여"),
    TRUE("참석"),
    FALSE("불참");

    private final String description;
}
