package com.fcprovin.admin.web.member.controller;

import com.fcprovin.admin.domain.Member;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.member.form.MemberCreateForm;
import com.fcprovin.admin.web.member.search.MemberSearch;
import com.fcprovin.admin.web.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String list(MemberSearch search, Model model) {
        model.addAttribute("list", memberService.findAll(search));
        return "/member/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", memberService.find(id));
        return "/member/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Member());
        return "/member/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") MemberCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", memberService.create(form));
        return "redirect:/member/detail/{id}";
    }
}
