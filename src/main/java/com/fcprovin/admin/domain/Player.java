package com.fcprovin.admin.domain;

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
