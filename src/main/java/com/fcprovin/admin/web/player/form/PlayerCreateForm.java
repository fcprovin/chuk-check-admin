package com.fcprovin.admin.web.player.form;

import com.fcprovin.admin.domain.PlayerAuthority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class PlayerCreateForm {

    @NotEmpty
    private Long memberId;

    @NotEmpty
    private Long teamId;

    @NotEmpty
    private PlayerAuthority authority;

    @Builder
    public PlayerCreateForm(Long memberId, Long teamId, PlayerAuthority authority) {
        this.memberId = memberId;
        this.teamId = teamId;
        this.authority = authority;
    }
}
