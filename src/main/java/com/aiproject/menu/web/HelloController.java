package com.aiproject.menu.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @PostMapping("/api/v1/senddata")
    public String sendPostData(@RequestParam(value = "data") String data) {
        return "당신이 입력한 데이터는? " + data;
    }

    @GetMapping("/api/v1/sendgetdata")
    public String sendGetData(@RequestParam(value = "data", defaultValue = "없음") String data) {
        return "당신이 입력한 데이터는? " + data;
    }
}
