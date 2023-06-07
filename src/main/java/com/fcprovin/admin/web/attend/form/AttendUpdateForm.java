package com.fcprovin.admin.web.attend.form;

import com.fcprovin.admin.domain.AttendStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class AttendUpdateForm {

    private AttendStatus status;

    public AttendUpdateForm(AttendStatus status) {
        this.status = status;
    }
}
