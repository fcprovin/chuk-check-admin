package com.fcprovin.admin.web.vote.controller;

import com.fcprovin.admin.web.match.search.MatchSearch;
import com.fcprovin.admin.web.match.service.MatchService;
import com.fcprovin.admin.web.player.search.PlayerSearch;
import com.fcprovin.admin.web.player.service.PlayerService;
import com.fcprovin.admin.web.team.search.TeamSearch;
import com.fcprovin.admin.web.team.service.TeamService;
import com.fcprovin.admin.web.vote.domain.VoteStatus;
import com.fcprovin.admin.web.vote.form.VoteCreateForm;
import com.fcprovin.admin.web.vote.form.VoteUpdateForm;
import com.fcprovin.admin.web.vote.search.VoteSearch;
import com.fcprovin.admin.web.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.fcprovin.admin.web.common.domain.BaseStatus.APPROVE;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;
    private final TeamService teamService;
    private final MatchService matchService;
    private final PlayerService playerService;

    @ModelAttribute
    public List<VoteStatus> voteStatusList() {
        return stream(VoteStatus.values()).collect(toList());
    }

    @GetMapping
    public String list(VoteSearch search, Model model) {
        model.addAttribute("list", voteService.list(search));
        return "/vote/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", voteService.detail(id));
        return "/vote/detail";
    }

    @GetMapping("/add")
    public String add(Model model, @RequestParam(required = false) Long teamId) {
        model.addAttribute("teamList", teamService.list(TeamSearch.builder().status(APPROVE).build()));
        model.addAttribute("playerList", playerService.list(PlayerSearch.builder().teamId(teamId).build()));
        model.addAttribute("matchList", matchService.list(MatchSearch.builder().teamId(teamId).build()));
        model.addAttribute("item", new VoteCreateForm());
        model.addAttribute("teamId", teamId);
        return "/vote/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") VoteCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", voteService.add(form).getId());
        return "redirect:/vote/{id}";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {
        model.addAttribute("item", voteService.detail(id));
        return "/vote/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id, @Validated @ModelAttribute("item") VoteUpdateForm form) {
        voteService.modify(id, form);
        return "redirect:/vote/{id}";
    }
}
