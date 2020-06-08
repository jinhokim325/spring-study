package com.study.spring.boot.naver.service;

import com.study.spring.boot.naver.dto.BlogDto;
import com.study.spring.boot.naver.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BlogService {
    private BlogRepository blogRepository;

    public List<BlogDto> findByKeyword(String keyword) {

        return blogRepository.findByKeyword(keyword).getItems().stream()
                .map(m -> BlogDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .description(m.getDescription())
                        .bloggername(m.getBloggername())
                        .bloggerlink(m.getBloggerlink())
                        .build())
                    .collect(Collectors.toList());
    }
}
