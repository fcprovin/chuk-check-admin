package com.fcprovin.admin.web.match.controller;

import com.fcprovin.admin.domain.Match;
import com.fcprovin.admin.domain.Player;
import com.fcprovin.admin.web.match.form.MatchCreateForm;
import com.fcprovin.admin.web.match.form.MatchUpdateForm;
import com.fcprovin.admin.web.match.search.MatchSearch;
import com.fcprovin.admin.web.match.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public String list(MatchSearch search, Model model) {
        model.addAttribute("list", matchService.findAll(search));
        return "/match/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", matchService.find(id));
        return "/match/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Match());
        return "/match/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") MatchCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", matchService.create(form));
        return "redirect:/match/detail/{id}";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("item", matchService.find(id));
        return "/match/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated @ModelAttribute("item") MatchUpdateForm form) {
        matchService.update(id, form);
        return "redirect:/match/detail/{id}";
    }
}
