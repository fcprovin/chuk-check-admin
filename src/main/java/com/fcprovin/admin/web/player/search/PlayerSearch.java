package com.fcprovin.admin.web.player.search;

import com.fcprovin.admin.web.SearchRequest;
import com.fcprovin.admin.web.common.domain.BaseStatus;
import com.fcprovin.admin.web.player.domain.PlayerAuthority;
import com.fcprovin.admin.web.player.domain.Position;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerSearch implements SearchRequest {

    private Long memberId;
    private Long teamId;
    private Position position;
    private BaseStatus status;
    private PlayerAuthority authority;
}
