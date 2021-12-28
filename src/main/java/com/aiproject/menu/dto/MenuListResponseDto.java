package com.aiproject.menu.dto;

import com.aiproject.menu.domain.menu.Menu;

import lombok.Getter;

@Getter
public class MenuListResponseDto {
    private Long id;
    private String menu;
    private String imgLink;

    public MenuListResponseDto(Menu entity) {
        this.id = entity.getId();
        this.menu = entity.getMenu();
        this.imgLink = entity.getImgLink();
    }
}
