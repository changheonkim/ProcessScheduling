package com.drag.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링 서버 전역적으로 CORS 설정
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**") // CORS를 적용할 URL패턴 정의
                .allowedOrigins("*") // 자원 공유를 허락할 Origin 지정
                .allowedMethods("GET", "POST", "DELETE", "PATCH") // 허용할 HTTP method 지정
                .maxAge(3000); // 설정 시간만큼 pre-flight 리퀘스트 캐싱
    }
}