package com.fcprovin.admin.web.attend.controller;

import com.fcprovin.admin.web.attend.domain.AttendStatus;
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

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/attend")
public class AttendController {

    private final AttendService attendService;

    @ModelAttribute
    public List<AttendStatus> attendStatusList() {
        return stream(AttendStatus.values()).collect(toList());
    }

    @GetMapping
    public String list(AttendSearch search, Model model) {
        model.addAttribute("list", attendService.list(search));
        return "/attend/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", attendService.detail(id));
        return "/attend/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new AttendCreateForm());
        return "/attend/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") AttendCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", attendService.add(form).getId());
        return "redirect:/attend/{id}";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {
        model.addAttribute("item", attendService.detail(id));
        return "/attend/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id, @Validated @ModelAttribute("item") AttendUpdateForm form) {
        attendService.modify(id, form);
        return "redirect:/attend/{id}";
    }
}
