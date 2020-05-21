package com.study.spring.boot.naver;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class MovieRepository {
    private String clientId = "PpIdE0YtU9uioLdU2yKW";
    private String clientSecret = "MdH0Dn0Bk0";

    public MovieResponseDto findByKeyword(String keyword) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", clientId);
        httpHeaders.add("X-Naver-Client-Secret", clientSecret);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        String url = "https://openapi.naver.com/v1/search/movie.json?query=" + keyword;

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, MovieResponseDto.class).getBody();
    }
}
