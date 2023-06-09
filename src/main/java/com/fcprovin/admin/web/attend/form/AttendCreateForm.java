package com.fcprovin.admin.web.attend.form;

import com.fcprovin.admin.domain.AttendStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class AttendCreateForm {

    @NotEmpty
    private Long playerId;

    @NotEmpty
    private Long matchId;

    @NotEmpty
    private AttendStatus status;

    @Builder
    public AttendCreateForm(Long playerId, Long matchId, AttendStatus status) {
        this.playerId = playerId;
        this.matchId = matchId;
        this.status = status;
    }
}
