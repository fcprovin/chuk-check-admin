package com.fcprovin.admin.web.team.controller;

import com.fcprovin.admin.web.common.domain.BaseStatus;
import com.fcprovin.admin.web.team.form.TeamCreateForm;
import com.fcprovin.admin.web.team.form.TeamUpdateForm;
import com.fcprovin.admin.web.team.search.TeamSearch;
import com.fcprovin.admin.web.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @ModelAttribute
    public List<BaseStatus> baseStatusList() {
        return stream(BaseStatus.values()).collect(toList());
    }

    @GetMapping
    public String list(TeamSearch search, Model model) {
        model.addAttribute("list", teamService.list(search));
        return "/team/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", teamService.detail(id));
        return "/team/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new TeamCreateForm());
        return "/team/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") TeamCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", teamService.add(form).getId());
        return "redirect:/team/{id}";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {
        model.addAttribute("item", teamService.detail(id));
        return "/team/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id, @Validated @ModelAttribute("item") TeamUpdateForm form) {
        teamService.modify(id, form);
        return "redirect:/team/{id}";
    }
}
