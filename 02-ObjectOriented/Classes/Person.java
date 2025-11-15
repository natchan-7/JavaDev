package Classes;

/**
 * Person.java
 * クラスの基本を学習するサンプル
 * - フィールド（属性）
 * - コンストラクタ
 * - メソッド（振る舞い）
 * - カプセル化（getter/setter）
 */
public class Person {
    // フィールド（private: カプセル化）
    private String name;
    private int age;
    private String email;

    // デフォルトコンストラクタ
    public Person() {
        this.name = "名無し";
        this.age = 0;
        this.email = "";
    }

    // パラメータ付きコンストラクタ
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "";
    }

    // 完全なコンストラクタ
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getter/Setter（カプセル化）
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("無効な年齢です");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // メソッド
    public void introduce() {
        System.out.println("こんにちは、私は" + name + "です。" + age + "歳です。");
    }

    public boolean isAdult() {
        return age >= 18;
    }

    // toString()のオーバーライド
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }

    // メインメソッド（テスト用）
    public static void main(String[] args) {
        // オブジェクトの生成
        Person person1 = new Person();
        System.out.println("person1: " + person1);

        Person person2 = new Person("太郎", 25);
        person2.introduce();
        System.out.println("成人: " + person2.isAdult());

        Person person3 = new Person("花子", 17, "hanako@example.com");
        System.out.println("person3: " + person3);
        System.out.println("成人: " + person3.isAdult());

        // Setterの使用
        person1.setName("次郎");
        person1.setAge(30);
        person1.setEmail("jiro@example.com");
        System.out.println("更新後のperson1: " + person1);
    }
}
