package com.fcprovin.admin.web.attend.form;

import com.fcprovin.admin.web.attend.domain.AttendStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendCreateForm {

    @NotNull
    private Long playerId;

    @NotNull
    private Long matchId;

    @NotEmpty
    private AttendStatus status;
}
