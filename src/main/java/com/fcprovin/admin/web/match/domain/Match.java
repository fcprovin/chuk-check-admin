package com.fcprovin.admin.web.match.domain;

import com.fcprovin.admin.web.attend.domain.AttendDate;
import com.fcprovin.admin.web.stadium.domain.Stadium;
import com.fcprovin.admin.web.team.domain.Team;
import com.fcprovin.admin.web.vote.domain.VoteDate;
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
