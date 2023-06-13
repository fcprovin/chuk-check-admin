package com.fcprovin.admin.web.member.controller;

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
        model.addAttribute("list", memberService.list(search));
        return "member/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", memberService.detail(id));
        return "member/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new MemberCreateForm());
        return "member/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") MemberCreateForm form,
                      RedirectAttributes attributes) {
        attributes.addAttribute("id", memberService.add(form).getId());
        return "redirect:/member/{id}";
    }
}
