package com.bachelor.backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
