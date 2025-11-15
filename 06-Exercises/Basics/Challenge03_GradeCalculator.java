/**
 * Challenge03_GradeCalculator.java
 * バグ修正チャレンジ: 成績判定プログラム
 *
 * 【問題】
 * このプログラムには6つのバグがあります。すべて見つけて修正してください。
 *
 * 【期待される動作】
 * 1. 点数に応じて正しい評価を表示する
 *    90-100: A, 80-89: B, 70-79: C, 60-69: D, 0-59: F
 * 2. 合格/不合格を正しく判定する（60点以上で合格）
 * 3. 複数の学生の成績を処理する
 *
 * 【難易度】★★☆☆☆（初級〜中級）
 */
public class Challenge03_GradeCalculator {

    public static void main(String[] args) {
        String[] students = {"太郎", "花子", "次郎", "美咲"};
        int[] scores = {85, 92, 58, 73};

        System.out.println("=== 成績判定プログラム ===\n");

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + "さんの成績:");
            System.out.println("点数: " + scores[i]);

            // バグ1: 評価判定の条件が重複している
            String grade;
            if (scores[i] >= 90) {
                grade = "A";
            } else if (scores[i] >= 80) {
                grade = "B";
            } else if (scores[i] >= 80) {  // バグ: 80以上が重複
                grade = "C";
            } else if (scores[i] >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            System.out.println("評価: " + grade);

            // バグ2: 合格判定の条件が逆
            if (scores[i] < 60) {
                System.out.println("結果: 合格");
            } else {
                System.out.println("結果: 不合格");
            }

            // バグ3: switch文のbreak忘れ
            String comment;
            switch (grade) {
                case "A":
                    comment = "優秀です！";
                case "B":
                    comment = "良好です！";
                    break;
                case "C":
                    comment = "普通です";
                    break;
                case "D":
                    comment = "もう少し頑張りましょう";
                    break;
                default:
                    comment = "再試験が必要です";
            }
            System.out.println("コメント: " + comment);

            // バグ4: 条件演算子の条件が間違っている
            String status = (scores[i] >= 90) ? "優秀" : "要努力";
            System.out.println("ステータス: " + status);

            System.out.println();
        }

        // バグ5: 平均点の計算で合計が整数のまま
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        int average = total / scores.length;
        System.out.println("クラス平均: " + average + "点");
    }
}

/**
 * ヒント:
 * 1. if-else文の条件範囲を確認しましょう（70-79がCのはず）
 * 2. 60点以上が合格です
 * 3. switchのcaseには必ずbreakを入れましょう
 * 4. 80点以上を「優秀」、それ以外を「要努力」とするのは厳しすぎませんか？
 * 5. 小数点以下の平均を表示するにはdoubleを使いましょう
 *
 * 期待される出力例（太郎さん、85点の場合）:
 * 太郎さんの成績:
 * 点数: 85
 * 評価: B
 * 結果: 合格
 * コメント: 良好です！
 * ステータス: 標準
 */
