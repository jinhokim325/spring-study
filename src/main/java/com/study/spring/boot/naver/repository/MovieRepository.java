package com.study.spring.boot.naver.repository;

import com.study.spring.boot.naver.config.NaverConfig;
import com.study.spring.boot.naver.dto.MovieResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Repository
public class MovieRepository {
    private final NaverConfig naverConfig;
    private final RestTemplate restTemplate;

    public MovieResponseDto findByKeyword(String keyword) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverConfig.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverConfig.getClientSecret());
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        String url = naverConfig.getMovieUrl() + "?query=" + keyword;

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, MovieResponseDto.class).getBody();
    }
}
