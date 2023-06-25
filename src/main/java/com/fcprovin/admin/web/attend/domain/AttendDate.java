package com.fcprovin.admin.web.attend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class AttendDate {

    private LocalDateTime deadlineDate;

    @Builder
    public AttendDate(LocalDateTime deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public static AttendDate of(LocalDateTime endDate) {
        return new AttendDate(endDate);
    }
}
