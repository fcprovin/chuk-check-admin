package com.fcprovin.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Sns sns;
}
