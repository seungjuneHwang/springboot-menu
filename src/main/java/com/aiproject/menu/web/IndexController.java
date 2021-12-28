package com.aiproject.menu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

   @GetMapping("/")
   public String index() {
       return "index";
   }

   @GetMapping("/hello")
   public String hello() {
       return "hello";
   }

   @GetMapping("/input")
   public String input() {
       return "input";
   }
}