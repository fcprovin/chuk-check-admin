package com.fcprovin.admin.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Position {

    FW("공격수"),
    MF("미드필더"),
    DF("수비수"),
    GK("골키퍼");

    private final String description;
}
