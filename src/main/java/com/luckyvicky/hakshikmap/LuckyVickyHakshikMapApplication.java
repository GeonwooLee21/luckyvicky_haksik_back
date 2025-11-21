package com.luckyvicky.hakshikmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LuckyVickyHakshikMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckyVickyHakshikMapApplication.class, args);
    }

}
