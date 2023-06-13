package com.fcprovin.admin.web.region.controller;

import com.fcprovin.admin.web.region.form.RegionCreateForm;
import com.fcprovin.admin.web.region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", regionService.list());
        return "/region/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new RegionCreateForm());
        return "/region/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") RegionCreateForm form) {
        regionService.add(form);
        return "redirect:/region";
    }
}
