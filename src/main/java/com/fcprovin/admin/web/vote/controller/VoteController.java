package com.fcprovin.admin.web.vote.controller;

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

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

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
    public String add(Model model) {
        model.addAttribute("item", new VoteCreateForm());
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
