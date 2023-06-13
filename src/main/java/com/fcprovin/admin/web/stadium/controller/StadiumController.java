package com.fcprovin.admin.web.stadium.controller;

import com.fcprovin.admin.web.stadium.form.StadiumCreateForm;
import com.fcprovin.admin.web.stadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", stadiumService.list());
        return "/stadium/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", stadiumService.detail(id));
        return "/stadium/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new StadiumCreateForm());
        return "/stadium/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") StadiumCreateForm form,
                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", stadiumService.add(form).getId());
        return "redirect:/stadium/{id}";
    }
}
