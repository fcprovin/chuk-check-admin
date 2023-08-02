package com.fcprovin.admin.web.vote.search;

import com.fcprovin.admin.web.SearchRequest;
import com.fcprovin.admin.web.vote.domain.VoteStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoteSearch implements SearchRequest {

    private Long playerId;
    private Long matchId;
    private VoteStatus status;
}
