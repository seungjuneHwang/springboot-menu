package com.aiproject.menu.service;

import java.util.List;
import java.util.stream.Collectors;

import com.aiproject.menu.domain.menu.Menu;
import com.aiproject.menu.domain.menu.MenuRepository;
import com.aiproject.menu.dto.MenuListResponseDto;
import com.aiproject.menu.dto.MenuSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    
    // 데이터 넣기
    @Transactional
    public Long save(MenuSaveRequestDto requestDto) {
        return menuRepository.save(requestDto.toEntity()).getId();
    }

    // 전체 데이터 불러오기
    @Transactional(readOnly = true)
    public List<MenuListResponseDto> findAll() {
        return menuRepository.findAll().stream()
        .map(MenuListResponseDto::new)
        .collect(Collectors.toList());
    }

    // 데이터 수정
    @Transactional
    public Long update(Long id, MenuSaveRequestDto requestDto) {
        Menu menu = menuRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("수정할 메뉴가 없다." + id));
        
        menu.update(requestDto.getMenu(), requestDto.getImgLink());
        return id;
    }
}
