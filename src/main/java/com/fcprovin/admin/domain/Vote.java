package com.fcprovin.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    private Long id;
    private VoteStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Player player;
    private Match match;
}
