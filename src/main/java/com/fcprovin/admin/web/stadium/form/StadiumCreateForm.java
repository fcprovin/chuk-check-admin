package com.fcprovin.admin.web.stadium.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadiumCreateForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    private double latitude;

    private double longitude;
}
