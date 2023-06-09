package com.fcprovin.admin.web.stadium.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class StadiumCreateForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    private double latitude;

    private double longitude;

    @Builder
    public StadiumCreateForm(String name, String address, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
