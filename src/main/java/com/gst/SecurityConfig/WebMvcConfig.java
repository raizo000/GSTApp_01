package com.gst.SecurityConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/**
 * Created by jenov on 06/27/2017.
 */
@Configuration

public class WebMvcConfig extends WebMvcConfigurerAdapter {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Bean
    @Qualifier("Password")
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setSupportedMediaTypes(Collections.singletonList(new MediaType("text", "plain", UTF8)));
        converters.add(stringConverter);
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
