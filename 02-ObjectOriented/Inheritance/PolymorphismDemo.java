package Inheritance;

/**
 * PolymorphismDemo.java
 * ポリモーフィズム（多態性）を学習するサンプル
 * - 親クラス型の変数で子クラスのオブジェクトを参照
 * - メソッドの動的ディスパッチ
 */
public class PolymorphismDemo {

    public static void main(String[] args) {
        System.out.println("=== ポリモーフィズムのデモ ===\n");

        // ポリモーフィズム: Animal型の変数で異なる動物を参照
        Animal animal1 = new Dog("ポチ", 3, "柴犬");
        Animal animal2 = new Cat("タマ", 2, true);
        Animal animal3 = new Animal("謎の動物", 5);

        // 配列でまとめて管理
        Animal[] animals = {animal1, animal2, animal3};

        // ループで処理 - それぞれの実際の型に応じたメソッドが呼ばれる
        for (Animal animal : animals) {
            System.out.println("--- " + animal.getName() + " ---");
            animal.displayInfo();
            animal.makeSound();  // 実際のオブジェクトの型に応じたメソッドが呼ばれる
            animal.eat();
            System.out.println();
        }

        // メソッドにポリモーフィズムを利用
        System.out.println("=== メソッドでのポリモーフィズム ===");
        performAnimalActions(new Dog("シロ", 4, "ゴールデンレトリバー"));
        performAnimalActions(new Cat("ミケ", 3, false));

        // instanceof演算子で型チェック
        System.out.println("\n=== 型チェック ===");
        checkAnimalType(animal1);
        checkAnimalType(animal2);
        checkAnimalType(animal3);

        // キャスト（型変換）
        System.out.println("\n=== キャストの例 ===");
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1;  // ダウンキャスト
            dog.fetch();  // Dog特有のメソッドを呼び出せる
            dog.wagTail();
        }

        if (animal2 instanceof Cat) {
            Cat cat = (Cat) animal2;  // ダウンキャスト
            cat.scratch();  // Cat特有のメソッドを呼び出せる
            cat.purr();
        }
    }

    /**
     * ポリモーフィズムを利用したメソッド
     * Animal型のパラメータで、Dog/Cat/Animalのどれでも受け取れる
     */
    public static void performAnimalActions(Animal animal) {
        System.out.println(animal.getName() + "のアクション:");
        animal.displayInfo();
        animal.makeSound();
        animal.sleep();
        System.out.println();
    }

    /**
     * instanceof演算子で実際の型をチェック
     */
    public static void checkAnimalType(Animal animal) {
        System.out.print(animal.getName() + "は ");
        if (animal instanceof Dog) {
            System.out.println("犬です");
        } else if (animal instanceof Cat) {
            System.out.println("猫です");
        } else {
            System.out.println("一般的な動物です");
        }
    }
}
