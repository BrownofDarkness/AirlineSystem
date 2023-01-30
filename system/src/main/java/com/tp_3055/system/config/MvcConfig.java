package com.tp_3055.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**") // « /static/css/myStatic.css
                .addResourceLocations("classpath:/static/") // Default Static Loaction
                .setCachePeriod( 3600 )
                .resourceChain(true)
                .addResolver(new PathResourceResolver()); //4.1


    }
}