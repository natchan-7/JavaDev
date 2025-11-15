/**
 * Methods.java
 * Javaのメソッド（関数）を学習するサンプル
 */
public class Methods {

    public static void main(String[] args) {
        // メソッド呼び出し
        greet();
        greetWithName("太郎");

        int sum = add(10, 20);
        System.out.println("10 + 20 = " + sum);

        double area = calculateCircleArea(5.0);
        System.out.println("半径5の円の面積: " + area);

        // 可変長引数
        int total = sumAll(1, 2, 3, 4, 5);
        System.out.println("合計: " + total);

        // オーバーロード
        System.out.println("multiply(5, 3) = " + multiply(5, 3));
        System.out.println("multiply(5.5, 2.0) = " + multiply(5.5, 2.0));
        System.out.println("multiply(5, 3, 2) = " + multiply(5, 3, 2));

        // 再帰
        System.out.println("5の階乗: " + factorial(5));
    }

    /**
     * 引数なし・戻り値なしのメソッド
     */
    public static void greet() {
        System.out.println("こんにちは！");
    }

    /**
     * 引数あり・戻り値なしのメソッド
     * @param name 名前
     */
    public static void greetWithName(String name) {
        System.out.println("こんにちは、" + name + "さん！");
    }

    /**
     * 引数あり・戻り値ありのメソッド
     * @param a 数値1
     * @param b 数値2
     * @return a + b の結果
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * 円の面積を計算
     * @param radius 半径
     * @return 面積
     */
    public static double calculateCircleArea(double radius) {
        final double PI = 3.14159;
        return PI * radius * radius;
    }

    /**
     * 可変長引数のメソッド
     * @param numbers 任意の数の整数
     * @return すべての数値の合計
     */
    public static int sumAll(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    /**
     * メソッドのオーバーロード（1）: int型の掛け算
     * @param a 数値1
     * @param b 数値2
     * @return a × b
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * メソッドのオーバーロード（2）: double型の掛け算
     * @param a 数値1
     * @param b 数値2
     * @return a × b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * メソッドのオーバーロード（3）: 3つの整数の掛け算
     * @param a 数値1
     * @param b 数値2
     * @param c 数値3
     * @return a × b × c
     */
    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    /**
     * 再帰メソッド: 階乗を計算
     * @param n 数値
     * @return n!（nの階乗）
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
