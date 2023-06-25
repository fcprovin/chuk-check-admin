package com.fcprovin.admin.web.attend.search;

import com.fcprovin.admin.web.SearchRequest;
import com.fcprovin.admin.web.attend.domain.AttendStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttendSearch implements SearchRequest {

    private Long playerId;
    private Long matchId;
    private AttendStatus status;
}
