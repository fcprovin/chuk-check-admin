package com.fcprovin.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private Long id;
    private String otherTeamName;
    private Boolean home;
    private String notice;
    private MatchStatus status;
    private MatchDate matchDate;
    private VoteDate voteDate;
    private AttendDate attendDate;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Team team;
    private Stadium stadium;
}
