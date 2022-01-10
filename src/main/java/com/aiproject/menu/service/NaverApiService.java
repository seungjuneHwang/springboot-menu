package com.aiproject.menu.service;

import com.aiproject.menu.utils.NaverAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NaverApiService {
    private final NaverAPI api;
    public String searchNews(String data) {
        return api.searchNews(data);
    }
}
