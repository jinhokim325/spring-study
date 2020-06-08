package com.study.spring.boot.naver.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class BlogResponseDto {
    private List<Item> items;

    @Getter
    public static class Item {
        String title;
        String link;
        String description;
        String bloggername;
        String bloggerlink;
    }
}
