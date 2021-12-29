package com.aiproject.menu.service;

import com.aiproject.menu.utils.NaverAPI;

import org.springframework.stereotype.Service;

@Service
public class NaverApiService {
    public String searchNews(String data) {
        return NaverAPI.searchNews(data);
    }
}
