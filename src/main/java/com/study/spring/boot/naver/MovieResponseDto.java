package com.study.spring.boot.naver;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
public class MovieResponseDto {
    private List<Item> items;

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
