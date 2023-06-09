package com.fcprovin.admin.web.team.controller;

import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.domain.Team;
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

@Controller
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public String list(TeamSearch search, Model model) {
        model.addAttribute("list", teamService.findAll(search));
        return "/team/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", teamService.find(id));
        return "/team/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Team());
        return "/team/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") TeamCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", teamService.create(form));
        return "redirect:/team/detail/{id}";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("item", teamService.find(id));
        return "/team/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated @ModelAttribute("item") TeamUpdateForm form) {
        teamService.update(id, form);
        return "redirect:/team/detail/{id}";
    }
}
