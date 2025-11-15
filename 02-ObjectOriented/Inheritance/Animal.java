package Inheritance;

/**
 * Animal.java
 * 継承の基本を学習するサンプル - 親クラス（スーパークラス）
 */
public class Animal {
    // 共通のフィールド
    protected String name;
    protected int age;

    // コンストラクタ
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 共通のメソッド
    public void eat() {
        System.out.println(name + "が食事をしています");
    }

    public void sleep() {
        System.out.println(name + "が眠っています");
    }

    // サブクラスでオーバーライドされることを想定したメソッド
    public void makeSound() {
        System.out.println(name + "が音を出しています");
    }

    // 情報表示
    public void displayInfo() {
        System.out.println("名前: " + name + ", 年齢: " + age + "歳");
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
