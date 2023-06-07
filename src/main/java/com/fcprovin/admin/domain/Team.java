package com.fcprovin.admin.domain;

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
