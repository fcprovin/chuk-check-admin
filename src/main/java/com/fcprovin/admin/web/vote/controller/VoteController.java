package com.fcprovin.admin.web.vote.controller;

import com.fcprovin.admin.domain.Match;
import com.fcprovin.admin.domain.Vote;
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

@Controller
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    @GetMapping
    public String list(VoteSearch search, Model model) {
        model.addAttribute("list", voteService.findAll(search));
        return "/vote/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", voteService.find(id));
        return "/vote/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Vote());
        return "/vote/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") VoteCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", voteService.create(form));
        return "redirect:/vote/detail/{id}";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("item", voteService.find(id));
        return "/vote/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated @ModelAttribute("item") VoteUpdateForm form) {
        voteService.update(id, form);
        return "redirect:/vote/detail/{id}";
    }
}
