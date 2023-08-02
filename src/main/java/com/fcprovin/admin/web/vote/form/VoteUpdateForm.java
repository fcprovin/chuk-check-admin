package com.fcprovin.admin.web.vote.form;

import com.fcprovin.admin.web.vote.domain.VoteStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class VoteUpdateForm {

    private VoteStatus status;

    public VoteUpdateForm(VoteStatus status) {
        this.status = status;
    }
}
