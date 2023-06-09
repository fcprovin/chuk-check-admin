package com.fcprovin.admin.web.team.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class TeamCreateForm {

    @NotEmpty
    private Long regionId;

    @NotEmpty
    private String name;

    @Builder
    public TeamCreateForm(Long regionId, String name) {
        this.regionId = regionId;
        this.name = name;
    }
}
