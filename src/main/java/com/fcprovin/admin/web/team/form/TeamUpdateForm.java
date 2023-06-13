package com.fcprovin.admin.web.team.form;

import com.fcprovin.admin.web.common.domain.BaseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class TeamUpdateForm {

    private BaseStatus status;

    @Builder
    public TeamUpdateForm(BaseStatus status) {
        this.status = status;
    }
}
