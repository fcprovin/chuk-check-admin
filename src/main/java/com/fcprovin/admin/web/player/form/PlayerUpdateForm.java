package com.fcprovin.admin.web.player.form;

import com.fcprovin.admin.web.common.domain.BaseStatus;
import com.fcprovin.admin.web.player.domain.PlayerAuthority;
import com.fcprovin.admin.web.player.domain.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class PlayerUpdateForm {

    private Integer uniformNumber;
    private Position position;
    private BaseStatus status;
    private PlayerAuthority authority;

    @Builder
    public PlayerUpdateForm(Integer uniformNumber, Position position, BaseStatus status, PlayerAuthority authority) {
        this.uniformNumber = uniformNumber;
        this.position = position;
        this.status = status;
        this.authority = authority;
    }
}
