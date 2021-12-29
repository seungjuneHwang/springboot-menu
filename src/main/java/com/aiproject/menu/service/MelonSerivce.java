package com.aiproject.menu.service;

import java.util.List;

import com.aiproject.menu.dto.MusicInfoDto;
import com.aiproject.menu.utils.Melon;

import org.springframework.stereotype.Service;

@Service
public class MelonSerivce {
    public List<MusicInfoDto> findMusicList() {
        return Melon.getMusicList();
    }
}
