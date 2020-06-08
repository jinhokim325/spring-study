package com.study.spring.boot.naver.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BlogDto {
    private String title;
    private String link;
    private String description;
    private String bloggername;
    private String bloggerlink;
}
