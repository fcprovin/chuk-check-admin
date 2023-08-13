package com.fcprovin.admin.web.player.controller;

import com.fcprovin.admin.web.common.domain.BaseStatus;
import com.fcprovin.admin.web.member.search.MemberSearch;
import com.fcprovin.admin.web.member.service.MemberService;
import com.fcprovin.admin.web.player.domain.PlayerAuthority;
import com.fcprovin.admin.web.player.domain.Position;
import com.fcprovin.admin.web.player.form.PlayerCreateForm;
import com.fcprovin.admin.web.player.form.PlayerUpdateForm;
import com.fcprovin.admin.web.player.search.PlayerSearch;
import com.fcprovin.admin.web.player.service.PlayerService;
import com.fcprovin.admin.web.team.search.TeamSearch;
import com.fcprovin.admin.web.team.service.TeamService;
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
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;
    private final MemberService memberService;
    private final TeamService teamService;

    @ModelAttribute
    public List<BaseStatus> baseStatusList() {
        return stream(BaseStatus.values()).collect(toList());
    }

    @ModelAttribute
    public List<PlayerAuthority> playerAuthorityList() {
        return stream(PlayerAuthority.values()).collect(toList());
    }

    @ModelAttribute
    public List<Position> positionList() {
        return stream(Position.values()).collect(toList());
    }

    @GetMapping
    public String list(PlayerSearch search, Model model) {
        model.addAttribute("list", playerService.list(search));
        return "/player/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", playerService.detail(id));
        return "/player/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("memberList", memberService.list(MemberSearch.builder().build()));
        model.addAttribute("teamList", teamService.list(TeamSearch.builder().status(APPROVE).build()));
        model.addAttribute("item", new PlayerCreateForm());
        return "/player/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") PlayerCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", playerService.add(form).getId());
        return "redirect:/player/{id}";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {
        model.addAttribute("item", playerService.detail(id));
        return "/player/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id, @Validated @ModelAttribute("item") PlayerUpdateForm form) {
        playerService.modify(id, form);
        return "redirect:/player/{id}";
    }
}
