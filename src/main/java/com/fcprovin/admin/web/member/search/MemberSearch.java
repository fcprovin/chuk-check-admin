package com.fcprovin.admin.web.member.search;

import com.fcprovin.admin.web.SearchRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSearch implements SearchRequest {

    private String name;
    private String email;
}
