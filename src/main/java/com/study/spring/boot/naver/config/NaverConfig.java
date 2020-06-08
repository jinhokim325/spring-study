package com.study.spring.boot.naver.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "naver.openapi")
public class NaverConfig {
    private String clientId;
    private String clientSecret;
    private String movieUrl;
    private String blogUrl;
}
