package com.study.spring.boot.naver;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class MovieController {
    private MovieService movieService;

    @GetMapping("/movie")
    public List<MovieDto> searchByKeyword() {

        return movieService.findByKeyword("올드보이");
    }
}
