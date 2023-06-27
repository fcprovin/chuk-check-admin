package com.fcprovin.admin.web.vote.form;

import com.fcprovin.admin.web.vote.domain.VoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteCreateForm {

    @NotNull
    private Long playerId;

    @NotNull
    private Long matchId;

    @NotEmpty
    private VoteStatus status;
}
