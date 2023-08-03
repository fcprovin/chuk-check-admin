package com.fcprovin.admin.api.vo.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {

    private int code;
    private String message;
}
