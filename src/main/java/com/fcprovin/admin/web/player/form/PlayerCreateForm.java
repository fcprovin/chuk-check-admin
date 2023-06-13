package com.fcprovin.admin.web.player.form;

import com.fcprovin.admin.web.player.domain.PlayerAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCreateForm {

    @NotNull
    private Long memberId;

    @NotNull
    private Long teamId;

    @NotNull
    private PlayerAuthority authority;
}
