package com.webdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBootBasicsApp.java
 * Spring Boot Web開発の基礎を学習するサンプル
 *
 * 学習内容:
 * - @SpringBootApplication
 * - RESTコントローラー（@RestController）
 * - MVCコントローラー（@Controller）
 * - パスパラメータとリクエストパラメータ
 * - HTTPメソッド（GET, POST, PUT, DELETE）
 */
@SpringBootApplication
public class SpringBootBasicsApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicsApp.class, args);
        System.out.println("\n=================================");
        System.out.println("Spring Boot Application Started!");
        System.out.println("=================================");
        System.out.println("REST API Endpoints:");
        System.out.println("  GET    http://localhost:8080/api/greeting");
        System.out.println("  GET    http://localhost:8080/api/greeting?name=Taro");
        System.out.println("  GET    http://localhost:8080/api/users");
        System.out.println("  GET    http://localhost:8080/api/users/1");
        System.out.println("  POST   http://localhost:8080/api/users");
        System.out.println("  PUT    http://localhost:8080/api/users/1");
        System.out.println("  DELETE http://localhost:8080/api/users/1");
        System.out.println("=================================\n");
    }

    /**
     * REST APIコントローラー
     * JSONレスポンスを返す
     */
    @RestController
    @RequestMapping("/api")
    public static class ApiController {

        // シンプルなユーザーリスト（本来はデータベースを使用）
        private List<User> users = new ArrayList<>(List.of(
            new User(1L, "山田太郎", "yamada@example.com"),
            new User(2L, "佐藤花子", "sato@example.com"),
            new User(3L, "鈴木一郎", "suzuki@example.com")
        ));

        /**
         * GET: 挨拶メッセージ
         * 例: /api/greeting?name=Taro
         */
        @GetMapping("/greeting")
        public GreetingResponse greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {
            return new GreetingResponse("Hello, " + name + "!");
        }

        /**
         * GET: 全ユーザー取得
         */
        @GetMapping("/users")
        public List<User> getAllUsers() {
            return users;
        }

        /**
         * GET: 特定ユーザー取得
         * 例: /api/users/1
         */
        @GetMapping("/users/{id}")
        public User getUserById(@PathVariable Long id) {
            return users.stream()
                .filter(user -> user.id().equals(id))
                .findFirst()
                .orElse(null);
        }

        /**
         * POST: 新規ユーザー作成
         * リクエストボディ: {"id": 4, "name": "田中次郎", "email": "tanaka@example.com"}
         */
        @PostMapping("/users")
        public User createUser(@RequestBody User user) {
            users.add(user);
            return user;
        }

        /**
         * PUT: ユーザー更新
         * 例: /api/users/1
         */
        @PutMapping("/users/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).id().equals(id)) {
                    users.set(i, updatedUser);
                    return updatedUser;
                }
            }
            return null;
        }

        /**
         * DELETE: ユーザー削除
         * 例: /api/users/1
         */
        @DeleteMapping("/users/{id}")
        public String deleteUser(@PathVariable Long id) {
            users.removeIf(user -> user.id().equals(id));
            return "User " + id + " deleted";
        }
    }

    /**
     * レスポンス用のレコードクラス（Java 14+）
     */
    public record GreetingResponse(String message) {}

    /**
     * ユーザーモデル（Java 14+ Record）
     */
    public record User(Long id, String name, String email) {}
}
