package Inheritance;

/**
 * Cat.java
 * 継承の基本を学習するサンプル - もう一つの子クラス
 * Animalクラスを継承
 */
public class Cat extends Animal {
    // Cat特有のフィールド
    private boolean isIndoor;

    // コンストラクタ
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    // メソッドのオーバーライド
    @Override
    public void makeSound() {
        System.out.println(name + "がニャーニャー！と鳴いています");
    }

    // Cat特有のメソッド
    public void scratch() {
        System.out.println(name + "が爪を研いでいます");
    }

    public void purr() {
        System.out.println(name + "がゴロゴロと喉を鳴らしています");
    }

    // 親クラスのメソッドをオーバーライドして拡張
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("室内飼い: " + (isIndoor ? "はい" : "いいえ"));
    }

    // Getter
    public boolean isIndoor() {
        return isIndoor;
    }

    // メインメソッド（テスト用）
    public static void main(String[] args) {
        // Catオブジェクトの作成
        Cat cat = new Cat("タマ", 2, true);

        // 親クラスから継承したメソッド
        cat.displayInfo();
        cat.eat();
        cat.sleep();

        // オーバーライドしたメソッド
        cat.makeSound();

        // Cat特有のメソッド
        cat.scratch();
        cat.purr();
    }
}
