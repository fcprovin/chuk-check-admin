package com.fcprovin.admin.web.stadium.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stadium {

    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
