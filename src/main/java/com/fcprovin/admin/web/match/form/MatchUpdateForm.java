package com.fcprovin.admin.web.match.form;

import com.fcprovin.admin.domain.MatchStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class MatchUpdateForm {

    private Long stadiumId;
    private String otherTeamName;
    private Boolean home;
    private String notice;
    private MatchStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime voteStartDate;
    private LocalDateTime voteEndDate;
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
