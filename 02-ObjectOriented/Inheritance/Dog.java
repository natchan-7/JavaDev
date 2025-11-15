package Inheritance;

/**
 * Dog.java
 * 継承の基本を学習するサンプル - 子クラス（サブクラス）
 * Animalクラスを継承
 */
public class Dog extends Animal {
    // Dog特有のフィールド
    private String breed;

    // コンストラクタ
    public Dog(String name, int age, String breed) {
        // 親クラスのコンストラクタを呼び出す
        super(name, age);
        this.breed = breed;
    }

    // メソッドのオーバーライド
    @Override
    public void makeSound() {
        System.out.println(name + "がワンワン！と吠えています");
    }

    // Dog特有のメソッド
    public void fetch() {
        System.out.println(name + "がボールを取ってきました");
    }

    public void wagTail() {
        System.out.println(name + "が尻尾を振って喜んでいます");
    }

    // 親クラスのメソッドをオーバーライドして拡張
    @Override
    public void displayInfo() {
        super.displayInfo();  // 親クラスのメソッドを呼び出す
        System.out.println("犬種: " + breed);
    }

    // Getter
    public String getBreed() {
        return breed;
    }

    // メインメソッド（テスト用）
    public static void main(String[] args) {
        // Dogオブジェクトの作成
        Dog dog = new Dog("ポチ", 3, "柴犬");

        // 親クラスから継承したメソッド
        dog.displayInfo();
        dog.eat();
        dog.sleep();

        // オーバーライドしたメソッド
        dog.makeSound();

        // Dog特有のメソッド
        dog.fetch();
        dog.wagTail();
    }
}
