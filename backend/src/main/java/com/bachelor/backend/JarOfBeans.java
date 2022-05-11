package com.bachelor.backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import java.text.DateFormat;

@Configuration
public class JarOfBeans {

    @Bean
    Gson getGsonBean() {
        return new GsonBuilder()
                .setDateFormat(DateFormat.FULL, DateFormat.FULL)
                .create();
    }

}
