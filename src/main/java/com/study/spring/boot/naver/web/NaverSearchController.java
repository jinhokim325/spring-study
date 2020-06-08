package com.study.spring.boot.naver.web;

import com.study.spring.boot.naver.dto.BlogDto;
import com.study.spring.boot.naver.service.BlogService;
import com.study.spring.boot.naver.service.MovieService;
import com.study.spring.boot.naver.dto.MovieDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class NaverSearchController {
    private MovieService movieService;

    private BlogService blogService;

    @GetMapping("/movie")
    public List<MovieDto> searchMovieByKeyword(@RequestParam(name = "keyword") String keyword) {

        return movieService.findByKeyword(keyword);
    }

    @GetMapping("/blog")
    public List<BlogDto> searchBlogByKeyword(@RequestParam(name = "keyword") String keyword) {

        return blogService.findByKeyword(keyword);
    }
}
