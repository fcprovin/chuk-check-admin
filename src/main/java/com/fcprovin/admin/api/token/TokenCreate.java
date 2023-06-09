package com.fcprovin.admin.api.token;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenCreate {

    private Long subject;
    private JwtRole scope;
}
