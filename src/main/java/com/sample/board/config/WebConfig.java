package com.sample.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // view 접근 경로
    private String resourcePath = "/upload/**";

    // 실제 파일 저장 경로 (windows, mac)
    // private String savePath = "file:///C:/springboot_img/";
    private String savePath = "file:///Users/ho_ong/Documents/project/spring-boot-board-sample/src/main/resources/springboot_img/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }

}
