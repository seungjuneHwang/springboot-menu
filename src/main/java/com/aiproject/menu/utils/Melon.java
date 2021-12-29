package com.aiproject.menu.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aiproject.menu.dto.MusicInfoDto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Melon {
    public static List<MusicInfoDto> getMusicList() {
        System.out.println("멜론 100 출력");
        List<MusicInfoDto> list = new ArrayList<MusicInfoDto>();
        String URL = "https://www.melon.com/chart/index.htm";

        try {
            Document doc = Jsoup.connect(URL).get();

            Elements tit = doc.select("div.ellipsis.rank01 > span > a");
            Elements artist = doc.select("div.ellipsis.rank02 > span");

            int rank = 0;
            // 임시 리스트
            List<String> tmpList = new ArrayList<>();
            for (Element e : artist) {
                // System.out.println(e.text());
                tmpList.add(e.text());
            }
            for (Element e : tit) {
                // System.out.println(e.text());
                MusicInfoDto dto = new MusicInfoDto();
                dto.setRank(rank + 1);
                dto.setTitle(e.text());
                dto.setArtist(tmpList.get(rank++));
                list.add(dto);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }
}
