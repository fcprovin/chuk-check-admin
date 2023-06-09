package com.fcprovin.admin.api.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.springframework.util.StringUtils.hasText;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private String accessToken;
    private String refreshToken;
    private LocalDateTime accessTokenExpireDate;
    private LocalDateTime refreshTokenExpireDate;

    public boolean validateAccessToken() {
        return hasText(accessToken) && now().isBefore(accessTokenExpireDate);
    }

    public boolean validateRefreshToken() {
        return hasText(refreshToken) && now().isBefore(refreshTokenExpireDate);
    }
}
