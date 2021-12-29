package com.aiproject.menu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

   @GetMapping("/melon")
   public String melon() {
       return "melon";
   }

   @GetMapping("/test")
   @ResponseBody  public String testApi() {
       return "test한글";
   }
}