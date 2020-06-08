package com.study.spring.boot.naver.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(2000);
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(20)
                .setMaxConnPerRoute(5)
                .build();
        factory.setHttpClient(httpClient);

        return new RestTemplate(factory);
    }
}