package com.fcprovin.admin.web.sns.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SnsType {

    GOOGLE("구글"),
    APPLE("애플"),
    NAVER("네이버"),
    KAKAO("카카오");

    private final String description;
}
