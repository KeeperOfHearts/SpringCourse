package com.love2code.springcoredemo.config;

import com.love2code.util.Coach;
import com.love2code.util.SwimCoach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
      return new SwimCoach();
    }

}
