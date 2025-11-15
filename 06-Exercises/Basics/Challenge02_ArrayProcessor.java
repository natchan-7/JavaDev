/**
 * Challenge02_ArrayProcessor.java
 * バグ修正チャレンジ: 配列処理プログラム
 *
 * 【問題】
 * このプログラムには4つのバグがあります。すべて見つけて修正してください。
 *
 * 【期待される動作】
 * 1. 配列の全要素を表示する
 * 2. 配列の合計値を計算する
 * 3. 配列の平均値を計算する
 * 4. 最大値を見つける
 *
 * 【難易度】★★☆☆☆（初級〜中級）
 */
public class Challenge02_ArrayProcessor {

    public static void main(String[] args) {
        int[] numbers = {10, 25, 3, 47, 15, 8, 32};

        System.out.println("=== 配列処理プログラム ===");

        // バグ1: 配列の範囲外アクセス
        System.out.println("配列の要素:");
        for (int i = 0; i <= numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // バグ2: 合計値の初期値が間違っている
        int sum = 1;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("合計: " + sum);

        // バグ3: 平均値が整数除算で切り捨てられる
        int average = sum / numbers.length;
        System.out.println("平均: " + average);

        // バグ4: 最大値の初期値が大きすぎる
        int max = 999999;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("最大値: " + max);
    }
}

/**
 * ヒント:
 * 1. 配列のインデックスは 0 から length-1 までです
 * 2. 合計を計算する時の初期値は通常 0 です
 * 3. 小数の平均を得るには double にキャストします
 * 4. 最大値を見つける時は、配列の最初の要素または Integer.MIN_VALUE で初期化します
 *
 * 期待される出力:
 * 配列の要素:
 * 10 25 3 47 15 8 32
 * 合計: 140
 * 平均: 20.0
 * 最大値: 47
 */
