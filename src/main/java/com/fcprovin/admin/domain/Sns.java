package com.fcprovin.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sns {

    private Long id;
    private String uuid;
    private SnsType type;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
