package com.fcprovin.admin.web.region.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class RegionCreateForm {

    @NotEmpty
    private String country;

    @NotEmpty
    private String city;

    @Builder
    public RegionCreateForm(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
