package com.fcprovin.admin.web.match.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchCreateForm {

    @NotNull
    private Long teamId;

    @NotNull
    private Long stadiumId;

    private String otherTeamName;

    @NotNull
    private Boolean home;

    private String notice;

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
}
