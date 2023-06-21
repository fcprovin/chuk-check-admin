package com.fcprovin.admin.web.match.form;

import com.fcprovin.admin.web.match.domain.MatchStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class MatchUpdateForm {

    private Long stadiumId;
    private String otherTeamName;
    private Boolean home;
    private String notice;
    private MatchStatus status;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime endDate;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime voteStartDate;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime voteEndDate;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime attendDeadlineDate;

    @Builder
    public MatchUpdateForm(Long stadiumId,
                           String otherTeamName,
                           Boolean home,
                           String notice,
                           MatchStatus status,
                           LocalDateTime startDate,
                           LocalDateTime endDate,
                           LocalDateTime voteStartDate,
                           LocalDateTime voteEndDate,
                           LocalDateTime attendDeadlineDate) {
        this.stadiumId = stadiumId;
        this.otherTeamName = otherTeamName;
        this.home = home;
        this.notice = notice;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.attendDeadlineDate = attendDeadlineDate;
    }
}
