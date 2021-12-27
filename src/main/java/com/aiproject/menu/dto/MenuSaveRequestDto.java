package com.aiproject.menu.dto;

import com.aiproject.menu.domain.menu.Menu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuSaveRequestDto {
    private String menu;
    private String imgLink;

    @Builder
    public MenuSaveRequestDto(String menu, String imgLink) {
        this.menu = menu;
        this.imgLink = imgLink;
    }

    public Menu toEntity() {
        return Menu.builder()
            .menu(menu)
            .imgLink(imgLink)
            .build();
    }
}
