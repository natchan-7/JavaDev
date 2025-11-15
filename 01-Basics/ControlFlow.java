/**
 * ControlFlow.java
 * Javaの制御構文（条件分岐・繰り返し）を学習するサンプル
 */
public class ControlFlow {

    public static void main(String[] args) {
        demonstrateIfElse();
        demonstrateSwitch();
        demonstrateLoops();
        demonstrateEnhancedForLoop();
    }

    /**
     * if-else文のデモンストレーション
     */
    public static void demonstrateIfElse() {
        System.out.println("=== if-else文 ===");
        int score = 85;

        if (score >= 90) {
            System.out.println("評価: A");
        } else if (score >= 80) {
            System.out.println("評価: B");
        } else if (score >= 70) {
            System.out.println("評価: C");
        } else {
            System.out.println("評価: D");
        }

        // 三項演算子
        String result = (score >= 60) ? "合格" : "不合格";
        System.out.println("結果: " + result);
        System.out.println();
    }

    /**
     * switch文のデモンストレーション
     */
    public static void demonstrateSwitch() {
        System.out.println("=== switch文 ===");
        String day = "月曜日";

        // 従来のswitch文
        switch (day) {
            case "月曜日":
                System.out.println("週の始まり");
                break;
            case "金曜日":
                System.out.println("週末まであと少し");
                break;
            case "土曜日":
            case "日曜日":
                System.out.println("週末です");
                break;
            default:
                System.out.println("平日です");
        }

        // Switch式（Java 14+）
        String mood = switch (day) {
            case "月曜日" -> "やる気を出そう";
            case "金曜日" -> "もうすぐ週末";
            case "土曜日", "日曜日" -> "リラックス";
            default -> "頑張ろう";
        };
        System.out.println("気分: " + mood);
        System.out.println();
    }

    /**
     * ループ（繰り返し）のデモンストレーション
     */
    public static void demonstrateLoops() {
        System.out.println("=== ループ ===");

        // for文
        System.out.print("for文: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // while文
        System.out.print("while文: ");
        int j = 1;
        while (j <= 5) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println();

        // do-while文
        System.out.print("do-while文: ");
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while (k <= 5);
        System.out.println();

        // break/continue
        System.out.print("break使用: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;  // 6で終了
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("continue使用: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;  // 偶数をスキップ
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    /**
     * 拡張for文（for-each）のデモンストレーション
     */
    public static void demonstrateEnhancedForLoop() {
        System.out.println("=== 拡張for文 ===");

        String[] fruits = {"りんご", "バナナ", "オレンジ", "ぶどう"};

        System.out.print("配列の要素: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }
}
