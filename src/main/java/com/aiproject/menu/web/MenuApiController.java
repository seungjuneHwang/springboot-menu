package com.aiproject.menu.web;

import java.util.List;

import com.aiproject.menu.dto.MenuListResponseDto;
import com.aiproject.menu.dto.MenuSaveRequestDto;
import com.aiproject.menu.service.MenuService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MenuApiController {
    private final MenuService menuService;

    @PostMapping("/api/v1/menusave")
    public Long save(@RequestBody MenuSaveRequestDto requestDto) {
        // System.out.println(requestDto.getMenu());
        // System.out.println(requestDto.getImgLink());
        return menuService.save(requestDto);
    }

    @GetMapping("/api/v1/menuall")
    public List<MenuListResponseDto> menuFindAll() {
        return menuService.findAll();
    }
    
}
