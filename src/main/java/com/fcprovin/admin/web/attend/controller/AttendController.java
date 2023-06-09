package com.fcprovin.admin.web.attend.controller;

import com.fcprovin.admin.domain.Attend;
import com.fcprovin.admin.domain.Match;
import com.fcprovin.admin.web.attend.form.AttendCreateForm;
import com.fcprovin.admin.web.attend.form.AttendUpdateForm;
import com.fcprovin.admin.web.attend.search.AttendSearch;
import com.fcprovin.admin.web.attend.service.AttendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/attend")
public class AttendController {

    private final AttendService attendService;

    @GetMapping
    public String list(AttendSearch search, Model model) {
        model.addAttribute("list", attendService.findAll(search));
        return "/attend/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", attendService.find(id));
        return "/attend/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Attend());
        return "/attend/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") AttendCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", attendService.create(form));
        return "redirect:/attend/detail/{id}";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("item", attendService.find(id));
        return "/attend/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated @ModelAttribute("item") AttendUpdateForm form) {
        attendService.update(id, form);
        return "redirect:/attend/detail/{id}";
    }
}
