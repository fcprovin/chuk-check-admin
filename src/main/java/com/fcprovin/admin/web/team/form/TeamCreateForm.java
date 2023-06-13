package com.fcprovin.admin.web.team.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreateForm {

    @NotNull
    private Long regionId;

    @NotEmpty
    private String name;
}
