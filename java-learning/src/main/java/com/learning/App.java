package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application Entry Point
 * Java/Spring Boot学習用メインアプリケーション
 */
@SpringBootApplication
public class App
{
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
        System.out.println("Spring Boot Application Started!");
        System.out.println("Visit: http://localhost:8080");
    }
}
