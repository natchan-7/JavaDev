package com.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基本的なREST APIコントローラー
 * Spring Boot Web開発の基礎を学ぶためのサンプル
 */
@RestController
public class HelloController {

    /**
     * ルートエンドポイント
     * @return ウェルカムメッセージ
     */
    @GetMapping("/")
    public String index() {
        return "Welcome to Java/Spring Boot Learning Project!";
    }

    /**
     * パラメータ付きエンドポイント
     * 例: http://localhost:8080/hello?name=Taro
     * @param name 名前（デフォルト: "World"）
     * @return 挨拶メッセージ
     */
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    /**
     * APIステータス確認用エンドポイント
     * @return APIステータス情報
     */
    @GetMapping("/api/status")
    public ApiStatus status() {
        return new ApiStatus("running", "Java/Spring Boot Learning API", "1.0.0");
    }

    /**
     * APIステータスを表すレコードクラス（Java 14+の新機能）
     */
    public record ApiStatus(String status, String name, String version) {}
}
