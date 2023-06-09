package com.fcprovin.admin.web.vote.form;

import com.fcprovin.admin.domain.VoteStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class VoteCreateForm {

    @NotEmpty
    private Long playerId;

    @NotEmpty
    private Long matchId;

    @NotEmpty
    private VoteStatus status;

    @Builder
    public VoteCreateForm(Long playerId, Long matchId, VoteStatus status) {
        this.playerId = playerId;
        this.matchId = matchId;
        this.status = status;
    }
}
