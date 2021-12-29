package com.aiproject.menu.web;

import java.util.List;

import com.aiproject.menu.dto.MusicInfoDto;
import com.aiproject.menu.service.MelonSerivce;
import com.aiproject.menu.service.NaverApiService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final MelonSerivce melonSerivce;
    private final NaverApiService naverApiSerivce;
    
    @PostMapping("/api/v1/senddata")
    public String sendPostData(@RequestParam(value = "data") String data) {
        return "당신이 입력한 데이터는? " + data;
    }

    @GetMapping("/api/v1/sendgetdata")
    public String sendGetData(@RequestParam(value = "data", defaultValue = "없음") String data) {
        return "당신이 입력한 데이터는? " + data;
    }

    @GetMapping("/api/v1/melon")
    public List<MusicInfoDto> melon() {
        return melonSerivce.findMusicList();
    }

    @GetMapping("/api/v1/news")
    public String news(@RequestParam(value = "data", defaultValue = "없음") String data) {
        System.out.println(data);
        return naverApiSerivce.searchNews(data);
    }

}
