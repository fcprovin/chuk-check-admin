package com.fcprovin.admin.web.match.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class MatchCreateForm {

    @NotEmpty
    private Long teamId;

    @NotEmpty
    private Long stadiumId;

    private String otherTeamName;

    @NotEmpty
    private Boolean home;

    private String notice;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime endDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime voteStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime voteEndDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime attendDeadlineDate;

    @Builder
    public MatchCreateForm(Long teamId,
                           Long stadiumId,
                           String otherTeamName,
                           Boolean home,
                           String notice,
                           LocalDateTime startDate,
                           LocalDateTime endDate,
                           LocalDateTime voteStartDate,
                           LocalDateTime voteEndDate,
                           LocalDateTime attendDeadlineDate) {
        this.teamId = teamId;
        this.stadiumId = stadiumId;
        this.otherTeamName = otherTeamName;
        this.home = home;
        this.notice = notice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.attendDeadlineDate = attendDeadlineDate;
    }
}
