package com.study.spring.boot.naver;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class MovieRepository {
    private String clientId = "";
    private String clientSecret = "";
    private String apiUrl = "https://openapi.naver.com/v1/search/movie.json?query=";

    public MovieResponseDto findByKeyword(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", clientId);
        httpHeaders.add("X-Naver-Client-Secret", clientSecret);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        String url = apiUrl + keyword;

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, MovieResponseDto.class).getBody();
    }
}
