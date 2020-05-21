package com.study.spring.boot.naver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public List<MovieDto> searchByKeyword() {

        return movieService.findByKeyword("올드보이");
    }
}
