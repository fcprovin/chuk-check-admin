package com.fcprovin.admin.web.match.search;

import com.fcprovin.admin.web.SearchRequest;
import com.fcprovin.admin.web.match.domain.MatchStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class MatchSearch implements SearchRequest {

    private Long teamId;
    private Long stadiumId;
    private MatchStatus status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
