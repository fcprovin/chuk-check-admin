package com.fcprovin.admin.web.player.controller;

import com.fcprovin.admin.domain.Player;
import com.fcprovin.admin.web.player.form.PlayerCreateForm;
import com.fcprovin.admin.web.player.form.PlayerUpdateForm;
import com.fcprovin.admin.web.player.search.PlayerSearch;
import com.fcprovin.admin.web.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public String list(PlayerSearch search, Model model) {
        model.addAttribute("list", playerService.findAll(search));
        return "/player/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("item", playerService.find(id));
        return "/player/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Player());
        return "/player/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("item") PlayerCreateForm form, RedirectAttributes attributes) {
        attributes.addAttribute("id", playerService.create(form));
        return "redirect:/player/detail/{id}";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("item", playerService.find(id));
        return "/player/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated @ModelAttribute("item") PlayerUpdateForm form) {
        playerService.update(id, form);
        return "redirect:/player/detail/{id}";
    }
}
