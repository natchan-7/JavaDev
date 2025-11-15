/**
 * Challenge01_Calculator_Solution.java
 * 解答例: 計算機プログラム
 *
 * バグ修正の解説付き
 */
public class Challenge01_Calculator_Solution {

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("=== 計算機プログラム ===");
        System.out.println("a = " + a + ", b = " + b);

        // 【修正1】加算の結果が文字列連結になっていた
        // 元: System.out.println("加算: " + a + b);
        // 問題: "加算: " + 10 + 5 → "加算: 10" + 5 → "加算: 105"
        // 解決: 括弧で囲んで先に計算させる
        System.out.println("加算: " + (a + b));

        // 【修正2】減算の演算子が間違っていた
        // 元: System.out.println("減算: " + (a * b));
        // 問題: 掛け算（*）を使っていた
        // 解決: 減算（-）に変更
        System.out.println("減算: " + (a - b));

        // 【修正3】整数の割り算で小数が切り捨てられる
        // 元: int result = a / 3;
        // 問題: 10 / 3 = 3.333... だが、int型では 3 になる
        // 解決: double型を使用
        double result = (double) a / 3;
        System.out.println("10 ÷ 3 = " + result);

        // 【修正4】ゼロ除算チェックの条件が逆
        // 元: if (divisor != 0)
        // 問題: ゼロでない時にエラーメッセージを出していた
        // 解決: divisor == 0 の時にエラーを出す
        int divisor = 0;
        if (divisor == 0) {
            System.out.println("エラー: ゼロで割ることはできません");
        } else {
            System.out.println("10 ÷ 0 = " + (10 / divisor));
        }

        // 【修正5】変数名のタイポ
        // 元: int sum = num1 + num3;
        // 問題: num3という変数は存在しない
        // 解決: num2に修正
        int num1 = 100;
        int num2 = 50;
        int sum = num1 + num2;
        System.out.println("合計: " + sum);
    }
}

/**
 * 【学習ポイント】
 *
 * 1. 文字列連結の優先順位
 *    - "文字列" + 数値1 + 数値2 は左から順に評価される
 *    - ("文字列" + 数値1) + 数値2 → "文字列数値1数値2"
 *    - 先に計算したい場合は括弧で囲む: "文字列" + (数値1 + 数値2)
 *
 * 2. 演算子の種類
 *    - + : 加算
 *    - - : 減算
 *    - * : 乗算
 *    - / : 除算
 *    - % : 剰余（余り）
 *
 * 3. 整数除算 vs 浮動小数点除算
 *    - int / int = int（小数点以下切り捨て）
 *    - double / double = double（小数点以下も保持）
 *    - (double) をつけることでキャスト（型変換）
 *
 * 4. ゼロ除算
 *    - 数値をゼロで割ることはできない（数学的に未定義）
 *    - Javaでは ArithmeticException が発生する
 *    - 事前にチェックして防ぐ
 *
 * 5. 変数名の正確さ
 *    - 存在しない変数を使うとコンパイルエラー
 *    - IDEの補完機能を活用してタイポを防ぐ
 *
 * 【実行結果】
 * === 計算機プログラム ===
 * a = 10, b = 5
 * 加算: 15
 * 減算: 5
 * 10 ÷ 3 = 3.3333333333333335
 * エラー: ゼロで割ることはできません
 * 合計: 150
 */
