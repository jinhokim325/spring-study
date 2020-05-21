package com.study.spring.boot.naver;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findByKeyword(String keyword) {

        return movieRepository.findByKeyword(keyword).getItems().stream()
                .map(m -> MovieDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .director(m.getDirector())
                        .userRating(m.getUserRating())
                        .build())
                    .collect(Collectors.toList());
    }
}
