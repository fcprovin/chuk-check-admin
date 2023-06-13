package com.fcprovin.admin.web.region.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    private Long id;
    private String country;
    private String city;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
