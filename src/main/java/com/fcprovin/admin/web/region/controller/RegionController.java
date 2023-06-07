package com.fcprovin.admin.web.region.controller;

import com.fcprovin.admin.domain.Region;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.region.form.RegionCreateForm;
import com.fcprovin.admin.web.region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", regionService.findAll());
        return "/region/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Region());
        return "/region/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") RegionCreateForm form,
                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", regionService.create(form));
        return "redirect:/region/detail/{id}";
    }
}
