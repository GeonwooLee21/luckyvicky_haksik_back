package com.luckyvicky.hakshikmap.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
/*
HTTP 동기 클라이언트 역할 수행
Spring에서 Python 서버로 HTTP 요청을 보냄
Python 서버에서 응답이 올 때 까지 기다림
* */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
