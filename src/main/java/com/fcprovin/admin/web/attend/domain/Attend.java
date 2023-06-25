package com.fcprovin.admin.web.attend.domain;

import com.fcprovin.admin.web.match.domain.Match;
import com.fcprovin.admin.web.player.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attend {

    private Long id;
    private AttendStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Player player;
    private Match match;
}
