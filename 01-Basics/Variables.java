/**
 * Variables.java
 * Javaの変数とデータ型を学習するサンプル
 */
public class Variables {

    public static void main(String[] args) {
        // プリミティブ型（基本データ型）

        // 整数型
        byte byteVar = 100;           // 8ビット: -128 ~ 127
        short shortVar = 10000;       // 16ビット: -32,768 ~ 32,767
        int intVar = 100000;          // 32ビット: 約-21億 ~ 21億
        long longVar = 10000000000L;  // 64ビット（末尾にL必須）

        // 浮動小数点型
        float floatVar = 3.14f;       // 32ビット（末尾にf必須）
        double doubleVar = 3.14159;   // 64ビット

        // 文字型
        char charVar = 'A';           // 16ビット（単一文字）

        // 論理型
        boolean boolVar = true;       // true または false

        // 参照型
        String stringVar = "Hello, Java!";

        // 出力
        System.out.println("=== プリミティブ型 ===");
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("char: " + charVar);
        System.out.println("boolean: " + boolVar);

        System.out.println("\n=== 参照型 ===");
        System.out.println("String: " + stringVar);

        // 定数（finalキーワード）
        final double PI = 3.14159;
        System.out.println("\n定数 PI: " + PI);
        // PI = 3.14; // エラー: 定数は再代入できない

        // 型推論（Java 10+）
        var autoInt = 100;           // int型と推論
        var autoString = "Auto";     // String型と推論
        System.out.println("\n型推論 var: " + autoInt + ", " + autoString);
    }
}
