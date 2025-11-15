package com.learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Spring Boot Application Test
 * JUnit 5を使用したテストクラス
 */
@SpringBootTest
public class AppTest
{
    /**
     * アプリケーションコンテキストが正常にロードされることを確認
     */
    @Test
    public void contextLoads() {
        assertTrue(true, "Application context should load successfully");
    }

    /**
     * 基本的なテストサンプル
     */
    @Test
    public void basicTest() {
        String expected = "Hello";
        String actual = "Hello";
        assertTrue(expected.equals(actual), "Strings should match");
    }
}
