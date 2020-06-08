package com.study.spring.boot.naver.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MovieDto {
    private String title;
    private String link;
    private String director;
    private String actor;
    private float userRating;
}
