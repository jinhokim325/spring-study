package com.study.spring.boot.naver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MovieService {
    private MovieRepository movieRepository;

    public List<MovieDto> findByKeyword(String keyword) {

        return movieRepository.findByKeyword(keyword).getItems().stream()
                .map(m -> MovieDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .director(m.getDirector())
                        .actor(m.getActor())
                        .userRating(m.getUserRating())
                        .build())
                    .collect(Collectors.toList());
    }
}
