package com.fcprovin.admin.web.sns.controller;

import com.fcprovin.admin.web.sns.form.SnsCreateForm;
import com.fcprovin.admin.domain.Sns;
import com.fcprovin.admin.web.sns.service.SnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sns")
public class SnsController {

    private final SnsService snsService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", snsService.findAll());
        return "/sns/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", snsService.find(id));
        return "/sns/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Sns());
        return "/sns/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") SnsCreateForm form,
                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", snsService.create(form));
        return "redirect:/sns/detail/{id}";
    }
}
