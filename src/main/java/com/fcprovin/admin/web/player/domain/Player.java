package com.fcprovin.admin.web.player.domain;

import com.fcprovin.admin.web.common.domain.BaseStatus;
import com.fcprovin.admin.web.member.domain.Member;
import com.fcprovin.admin.web.team.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private Long id;
    private Integer uniformNumber;
    private Position position;
    private BaseStatus status;
    private PlayerAuthority authority;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Member member;
    private Team team;
}
