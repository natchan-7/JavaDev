/**
 * Arrays.java
 * Javaの配列を学習するサンプル
 */
import java.util.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {
        demonstrateBasicArrays();
        demonstrateMultiDimensionalArrays();
        demonstrateArrayMethods();
    }

    /**
     * 基本的な配列の使い方
     */
    public static void demonstrateBasicArrays() {
        System.out.println("=== 基本的な配列 ===");

        // 配列の宣言と初期化（方法1）
        int[] numbers1 = {10, 20, 30, 40, 50};

        // 配列の宣言と初期化（方法2）
        int[] numbers2 = new int[5];
        numbers2[0] = 100;
        numbers2[1] = 200;
        numbers2[2] = 300;
        numbers2[3] = 400;
        numbers2[4] = 500;

        // 配列の要素にアクセス
        System.out.println("最初の要素: " + numbers1[0]);
        System.out.println("最後の要素: " + numbers1[numbers1.length - 1]);
        System.out.println("配列の長さ: " + numbers1.length);

        // 配列のループ
        System.out.print("numbers1の要素: ");
        for (int i = 0; i < numbers1.length; i++) {
            System.out.print(numbers1[i] + " ");
        }
        System.out.println();

        // 拡張for文
        System.out.print("numbers2の要素: ");
        for (int num : numbers2) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // 文字列配列
        String[] fruits = {"りんご", "バナナ", "オレンジ"};
        System.out.print("果物: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");
    }

    /**
     * 多次元配列
     */
    public static void demonstrateMultiDimensionalArrays() {
        System.out.println("=== 多次元配列 ===");

        // 2次元配列（行列）
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("2次元配列:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // 拡張for文で2次元配列を処理
        System.out.println("拡張for文で表示:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 配列の便利なメソッド
     */
    public static void demonstrateArrayMethods() {
        System.out.println("=== 配列の便利なメソッド ===");

        int[] numbers = {5, 2, 8, 1, 9, 3};

        // 配列を文字列に変換
        System.out.println("元の配列: " + Arrays.toString(numbers));

        // 配列のソート
        Arrays.sort(numbers);
        System.out.println("ソート後: " + Arrays.toString(numbers));

        // 配列の検索（二分探索 - ソート済み配列が必要）
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("値8のインデックス: " + index);

        // 配列のコピー
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("コピー: " + Arrays.toString(copy));

        // 配列の一部をコピー
        int[] partial = Arrays.copyOfRange(numbers, 1, 4);
        System.out.println("一部コピー[1-4]: " + Arrays.toString(partial));

        // 配列の比較
        boolean isEqual = Arrays.equals(numbers, copy);
        System.out.println("配列が等しい: " + isEqual);

        // 配列を特定の値で埋める
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("値7で埋めた配列: " + Arrays.toString(filled));
    }
}
