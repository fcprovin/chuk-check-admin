package com.fcprovin.admin.web.sns.form;

import com.fcprovin.admin.domain.SnsType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class SnsCreateForm {

    @NotEmpty
    private String uuid;

    private SnsType type;

    @Builder
    public SnsCreateForm(String uuid, SnsType type) {
        this.uuid = uuid;
        this.type = type;
    }
}
