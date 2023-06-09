package com.fcprovin.admin.web.member.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class MemberCreateForm {

    @NotEmpty
    private Long snsId;

    @NotEmpty
    private String name;

    @Email
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Builder
    public MemberCreateForm(Long snsId, String name, String email, LocalDate birthDate) {
        this.snsId = snsId;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }
}
