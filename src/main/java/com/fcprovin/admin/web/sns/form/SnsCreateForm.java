package com.fcprovin.admin.web.sns.form;

import com.fcprovin.admin.web.sns.domain.SnsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsCreateForm {

    @NotEmpty
    private String uuid;
    private SnsType type;
}
