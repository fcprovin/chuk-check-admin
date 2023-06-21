package com.fcprovin.admin.web.match.controller;

import com.fcprovin.admin.web.match.domain.MatchStatus;
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

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    @ModelAttribute
    public List<MatchStatus> matchStatusList() {
        return stream(MatchStatus.values()).collect(toList());
    }

    @GetMapping
    public String list(MatchSearch search, Model model) {
        model.addAttribute("list", matchService.list(search));
        return "/match/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", matchService.detail(id));
        return "/match/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new MatchCreateForm());
        return "/match/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") MatchCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", matchService.add(form).getId());
        return "redirect:/match/{id}";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {
        model.addAttribute("item", matchService.detail(id));
        return "/match/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id, @Validated @ModelAttribute("item") MatchUpdateForm form) {
        matchService.modify(id, form);
        return "redirect:/match/{id}";
    }
}
