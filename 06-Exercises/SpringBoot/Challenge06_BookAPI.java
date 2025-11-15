package exercises.springboot;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Challenge06_BookAPI.java
 * バグ修正チャレンジ: 書籍管理REST API
 *
 * 【問題】
 * このプログラムには8つのバグがあります。すべて見つけて修正してください。
 *
 * 【期待される動作】
 * 1. GET /api/books - 全書籍を取得
 * 2. GET /api/books/{id} - 特定の書籍を取得
 * 3. POST /api/books - 新規書籍を作成
 * 4. PUT /api/books/{id} - 書籍を更新
 * 5. DELETE /api/books/{id} - 書籍を削除
 *
 * 【難易度】★★★★☆（中級〜上級）
 */

// バグ1: @RestControllerアノテーションが抜けている
public class Challenge06_BookAPI {

    private List<Book> books = new ArrayList<>();
    private long nextId = 1;

    public Challenge06_BookAPI() {
        // 初期データ
        books.add(new Book(nextId++, "Javaの基礎", "山田太郎", 2800));
        books.add(new Book(nextId++, "Spring Boot入門", "佐藤花子", 3200));
    }

    // バグ2: @GetMappingのパスが抜けている
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // バグ3: @PathVariableの指定が抜けている
    @GetMapping("/api/books/{id}")
    public Book getBookById(Long id) {
        return books.stream()
            .filter(book -> book.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    // バグ4: @RequestBodyが抜けている
    @PostMapping("/api/books")
    public Book createBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    // バグ5: HTTPメソッドが間違っている（@GetMappingではなく@PutMapping）
    @GetMapping("/api/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                updatedBook.setId(id);
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }

    // バグ6: 削除メソッドの戻り値の型が間違っている（voidではなくString等を返すべき）
    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
        // 何も返していない
    }

    // バグ7: エンドポイントのパスが重複している
    @GetMapping("/api/books")
    public long getBookCount() {
        return books.size();
    }
}

class Book {
    private Long id;
    private String title;
    private String author;
    // バグ8: priceフィールドのgetter/setterが抜けている
    private int price;

    public Book() {}

    public Book(Long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // priceのgetter/setterが抜けている
}

/**
 * ヒント:
 * 1. REST APIを作るには @RestController アノテーションが必要です
 * 2. @GetMapping には URL パスを指定します（例: @GetMapping("/api/books")）
 * 3. パスパラメータを受け取るには @PathVariable を使います
 * 4. リクエストボディを受け取るには @RequestBody を使います
 * 5. 更新には @PutMapping を使います
 * 6. 削除の成功メッセージを返すようにしましょう
 * 7. 同じパスとHTTPメソッドの組み合わせは1つだけです
 * 8. すべてのフィールドにgetter/setterが必要です
 *
 * 修正後のテスト方法:
 * curl http://localhost:8080/api/books
 * curl http://localhost:8080/api/books/1
 * curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" \
 *   -d '{"title":"新しい本","author":"著者名","price":3000}'
 * curl -X PUT http://localhost:8080/api/books/1 -H "Content-Type: application/json" \
 *   -d '{"title":"更新された本","author":"著者名","price":3500}'
 * curl -X DELETE http://localhost:8080/api/books/1
 */
