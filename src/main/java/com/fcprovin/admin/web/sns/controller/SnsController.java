package com.fcprovin.admin.web.sns.controller;

import com.fcprovin.admin.web.sns.domain.SnsType;
import com.fcprovin.admin.web.sns.form.SnsCreateForm;
import com.fcprovin.admin.web.sns.service.SnsService;
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
@RequestMapping("/sns")
public class SnsController {

    private final SnsService snsService;

    @ModelAttribute
    public List<SnsType> snsTypeList() {
        return stream(SnsType.values()).collect(toList());
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", snsService.list());
        return "sns/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", snsService.detail(id));
        return "sns/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new SnsCreateForm());
        return "sns/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") SnsCreateForm form,
                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", snsService.add(form).getId());
        return "redirect:/sns/{id}";
    }
}
