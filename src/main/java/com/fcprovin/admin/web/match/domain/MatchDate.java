package com.fcprovin.admin.web.match.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class MatchDate {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Builder
    public MatchDate(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static MatchDate of(LocalDateTime startDate, LocalDateTime endDate) {
        return new MatchDate(startDate, endDate);
    }
}
