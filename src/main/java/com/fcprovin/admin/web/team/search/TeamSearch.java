package com.fcprovin.admin.web.team.search;

import com.fcprovin.admin.web.SearchRequest;
import com.fcprovin.admin.web.common.domain.BaseStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamSearch implements SearchRequest {

    private Long regionId;
    private String name;
    private BaseStatus status;
}
