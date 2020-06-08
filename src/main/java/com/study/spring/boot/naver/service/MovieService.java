package com.study.spring.boot.naver.service;

import com.study.spring.boot.naver.repository.MovieRepository;
import com.study.spring.boot.naver.dto.MovieDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MovieService {
    private MovieRepository movieRepository;

    public List<MovieDto> findByKeyword(String keyword) {
        List<MovieDto> movieDtoList = movieRepository.findByKeyword(keyword).getItems().stream()
                .map(m -> MovieDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .director(m.getDirector())
                        .actor(m.getActor())
                        .userRating(m.getUserRating())
                        .build())
                    .collect(Collectors.toList());

        // 영화 평점 높은순 정렬
        List<MovieDto> sortedList = movieDtoList.stream()
                                    .sorted(Comparator.comparing(MovieDto::getUserRating).reversed())
                                    .collect(Collectors.toList());

        return sortedList;
    }
}
