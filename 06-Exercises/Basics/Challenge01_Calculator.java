/**
 * Challenge01_Calculator.java
 * バグ修正チャレンジ: 計算機プログラム
 *
 * 【問題】
 * このプログラムには5つのバグがあります。すべて見つけて修正してください。
 *
 * 【期待される動作】
 * 1. 2つの整数の四則演算を正しく実行する
 * 2. ゼロ除算をチェックする
 * 3. 結果を正しく表示する
 *
 * 【難易度】★☆☆☆☆（初級）
 */
public class Challenge01_Calculator {

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("=== 計算機プログラム ===");
        System.out.println("a = " + a + ", b = " + b);

        // バグ1: 加算の結果が文字列連結になっている
        System.out.println("加算: " + a + b);

        // バグ2: 減算の演算子が間違っている
        System.out.println("減算: " + (a * b));

        // バグ3: 整数の割り算で小数が切り捨てられる
        int result = a / 3;
        System.out.println("10 ÷ 3 = " + result);

        // バグ4: ゼロ除算チェックの条件が逆
        int divisor = 0;
        if (divisor != 0) {
            System.out.println("10 ÷ 0 = " + (10 / divisor));
        } else {
            System.out.println("エラー: ゼロで割ることはできません");
        }

        // バグ5: 変数名のタイポ
        int num1 = 100;
        int num2 = 50;
        int sum = num1 + num3;  // num3は存在しない
        System.out.println("合計: " + sum);
    }
}

/**
 * ヒント:
 * 1. 文字列 + 数値 + 数値 の優先順位を考えてみましょう
 * 2. 減算は - 演算子を使います
 * 3. 小数を扱うには int ではなく double を使います
 * 4. ゼロ除算を防ぐには divisor == 0 の時にエラーを出します
 * 5. 変数名のスペルミスに注意しましょう
 */
