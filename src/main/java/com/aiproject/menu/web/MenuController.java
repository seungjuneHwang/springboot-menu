package com.aiproject.menu.web;

import com.aiproject.menu.service.MenuService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MenuController {

    private final MenuService menuService;

   @GetMapping("/menu")
   public String menu(Model model) {
       model.addAttribute("menulist", menuService.findAll());
       return "menu";
   }

   @GetMapping("/rndmenu")
   public String rndMenu() {
       return "rndmenu";
   }
}