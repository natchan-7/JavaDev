package practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TodoApp.java
 * コンソールベースのToDoアプリケーション
 *
 * 学習内容:
 * - オブジェクト指向設計の実践
 * - リスト操作（追加、削除、更新、検索）
 * - 日付・時刻の扱い
 * - ユーザー入力の処理
 * - メニュー駆動型アプリケーション
 */
public class TodoApp {

    private static List<TodoItem> todoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static long nextId = 1;

    public static void main(String[] args) {
        // サンプルデータの追加
        addSampleData();

        System.out.println("=================================");
        System.out.println("   ToDo管理アプリケーション");
        System.out.println("=================================\n");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> listAllTodos();
                case 2 -> addTodo();
                case 3 -> completeTodo();
                case 4 -> deleteTodo();
                case 5 -> searchTodo();
                case 6 -> showStatistics();
                case 0 -> {
                    System.out.println("\nアプリケーションを終了します。");
                    running = false;
                }
                default -> System.out.println("\n無効な選択です。もう一度お試しください。");
            }
        }

        scanner.close();
    }

    /**
     * メインメニューの表示
     */
    private static void displayMenu() {
        System.out.println("\n--- メニュー ---");
        System.out.println("1. ToDoリストを表示");
        System.out.println("2. ToDoを追加");
        System.out.println("3. ToDoを完了にする");
        System.out.println("4. ToDoを削除");
        System.out.println("5. ToDoを検索");
        System.out.println("6. 統計情報を表示");
        System.out.println("0. 終了");
        System.out.print("\n選択してください: ");
    }

    /**
     * ユーザーの選択を取得
     */
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * 全てのToDoを表示
     */
    private static void listAllTodos() {
        System.out.println("\n=== ToDoリスト ===");
        if (todoList.isEmpty()) {
            System.out.println("ToDoがありません。");
            return;
        }

        for (TodoItem todo : todoList) {
            System.out.println(todo);
        }
    }

    /**
     * 新しいToDoを追加
     */
    private static void addTodo() {
        System.out.print("\nToDoのタイトルを入力: ");
        String title = scanner.nextLine();

        System.out.print("説明を入力（省略可）: ");
        String description = scanner.nextLine();

        System.out.print("優先度を入力（高/中/低）: ");
        String priority = scanner.nextLine();

        TodoItem newTodo = new TodoItem(nextId++, title, description, priority);
        todoList.add(newTodo);

        System.out.println("\n✓ ToDoを追加しました: " + title);
    }

    /**
     * ToDoを完了にする
     */
    private static void completeTodo() {
        System.out.print("\n完了にするToDoのIDを入力: ");
        try {
            long id = Long.parseLong(scanner.nextLine());
            TodoItem todo = findTodoById(id);

            if (todo != null) {
                todo.markAsCompleted();
                System.out.println("\n✓ ToDoを完了にしました: " + todo.getTitle());
            } else {
                System.out.println("\n✗ 指定されたIDのToDoが見つかりません。");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n✗ 無効なIDです。");
        }
    }

    /**
     * ToDoを削除
     */
    private static void deleteTodo() {
        System.out.print("\n削除するToDoのIDを入力: ");
        try {
            long id = Long.parseLong(scanner.nextLine());
            TodoItem todo = findTodoById(id);

            if (todo != null) {
                todoList.remove(todo);
                System.out.println("\n✓ ToDoを削除しました: " + todo.getTitle());
            } else {
                System.out.println("\n✗ 指定されたIDのToDoが見つかりません。");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n✗ 無効なIDです。");
        }
    }

    /**
     * ToDoを検索
     */
    private static void searchTodo() {
        System.out.print("\n検索キーワードを入力: ");
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("\n=== 検索結果 ===");
        boolean found = false;

        for (TodoItem todo : todoList) {
            if (todo.getTitle().toLowerCase().contains(keyword) ||
                todo.getDescription().toLowerCase().contains(keyword)) {
                System.out.println(todo);
                found = true;
            }
        }

        if (!found) {
            System.out.println("該当するToDoが見つかりませんでした。");
        }
    }

    /**
     * 統計情報を表示
     */
    private static void showStatistics() {
        int total = todoList.size();
        long completed = todoList.stream().filter(TodoItem::isCompleted).count();
        long pending = total - completed;

        System.out.println("\n=== 統計情報 ===");
        System.out.println("総数: " + total);
        System.out.println("完了: " + completed);
        System.out.println("未完了: " + pending);
        if (total > 0) {
            double completionRate = (completed * 100.0) / total;
            System.out.printf("完了率: %.1f%%\n", completionRate);
        }
    }

    /**
     * IDでToDoを検索
     */
    private static TodoItem findTodoById(long id) {
        return todoList.stream()
            .filter(todo -> todo.getId() == id)
            .findFirst()
            .orElse(null);
    }

    /**
     * サンプルデータの追加
     */
    private static void addSampleData() {
        todoList.add(new TodoItem(nextId++, "Java基礎を学習", "変数、制御構文、メソッドを学ぶ", "高"));
        todoList.add(new TodoItem(nextId++, "Spring Bootチュートリアル", "公式ドキュメントを読む", "中"));
        todoList.add(new TodoItem(nextId++, "データベース設計", "ER図を作成する", "低"));
    }

    /**
     * ToDoアイテムクラス
     */
    static class TodoItem {
        private long id;
        private String title;
        private String description;
        private String priority;
        private boolean completed;
        private LocalDateTime createdAt;
        private LocalDateTime completedAt;

        public TodoItem(long id, String title, String description, String priority) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.completed = false;
            this.createdAt = LocalDateTime.now();
        }

        public void markAsCompleted() {
            this.completed = true;
            this.completedAt = LocalDateTime.now();
        }

        // Getters
        public long getId() { return id; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getPriority() { return priority; }
        public boolean isCompleted() { return completed; }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String status = completed ? "✓" : "○";
            String completedInfo = completed ? " (完了: " + completedAt.format(formatter) + ")" : "";

            return String.format("[%d] %s [%s] %s - %s (作成: %s)%s",
                id, status, priority, title, description,
                createdAt.format(formatter), completedInfo);
        }
    }
}
