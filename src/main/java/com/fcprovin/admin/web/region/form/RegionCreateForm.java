package com.fcprovin.admin.web.region.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionCreateForm {

    @NotEmpty
    private String country;

    @NotEmpty
    private String city;
}
