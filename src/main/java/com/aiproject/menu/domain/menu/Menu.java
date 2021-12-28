package com.aiproject.menu.domain.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String menu;

    @Column(length = 500, nullable = false)
    private String imgLink;

    @Builder
    public Menu(String menu, String imgLink) {
        this.menu = menu;
        this.imgLink = imgLink;
    }

    public void update(String menu, String imgLink) {
        this.menu = menu;
        this.imgLink = imgLink;
    }

}
