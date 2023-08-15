package com.fcprovin.admin;

import com.fcprovin.admin.web.attend.service.AttendService;
import com.fcprovin.admin.web.match.service.MatchService;
import com.fcprovin.admin.web.member.service.MemberService;
import com.fcprovin.admin.web.player.service.PlayerService;
import com.fcprovin.admin.web.region.service.RegionService;
import com.fcprovin.admin.web.sns.service.SnsService;
import com.fcprovin.admin.web.stadium.service.StadiumService;
import com.fcprovin.admin.web.team.service.TeamService;
import com.fcprovin.admin.web.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final SnsService snsService;
    private final MemberService memberService;
    private final TeamService teamService;
    private final PlayerService playerService;

    private final MatchService matchService;
    private final VoteService voteService;
    private final AttendService attendService;

    private final RegionService regionService;
    private final StadiumService stadiumService;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        log.info("userDetails.getUsername() = {}", userDetails.getUsername());
        model.addAttribute("sns", snsService.list().size());
        model.addAttribute("member", memberService.list().size());
        model.addAttribute("team", teamService.list().size());
        model.addAttribute("player", playerService.list().size());
        model.addAttribute("match", matchService.list().size());
        model.addAttribute("vote", voteService.list().size());
        model.addAttribute("attend", attendService.list().size());
        model.addAttribute("region", regionService.list().size());
        model.addAttribute("stadium", stadiumService.list().size());

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
