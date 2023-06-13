package com.fcprovin.admin.web.team.domain;

import com.fcprovin.admin.web.common.domain.BaseStatus;
import com.fcprovin.admin.web.region.domain.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    private Long id;
    private String name;
    private BaseStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Region region;
}
