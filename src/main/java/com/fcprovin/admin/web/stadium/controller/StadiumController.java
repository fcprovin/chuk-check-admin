package com.fcprovin.admin.web.stadium.controller;

import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.domain.Stadium;
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
        model.addAttribute("list", stadiumService.findAll());
        return "/stadium/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", stadiumService.find(id));
        return "/stadium/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Stadium());
        return "/stadium/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") StadiumCreateForm form,
                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", stadiumService.create(form));
        return "redirect:/stadium/detail/{id}";
    }
}
