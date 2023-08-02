package com.fcprovin.admin.web.vote.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class VoteDate {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Builder
    public VoteDate(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static VoteDate of(LocalDateTime startDate, LocalDateTime endDate) {
        return new VoteDate(startDate, endDate);
    }
}
