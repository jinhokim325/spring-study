package com.study.spring.boot.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MovieResponseDto {
    private List<Item> items;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Item {
        String title;
        String link;
        String director;
        String subtitle;
        Date pubDate;
        String actor;
        float userRating;
    }
}
