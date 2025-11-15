package exercises;

/**
 * Challenge04_StudentManagement.java
 * バグ修正チャレンジ: 学生管理システム
 *
 * 【問題】
 * このプログラムには7つのバグがあります。すべて見つけて修正してください。
 *
 * 【期待される動作】
 * 1. 学生情報を適切にカプセル化する
 * 2. 成績の平均を正しく計算する
 * 3. オブジェクトの比較を正しく行う
 *
 * 【難易度】★★★☆☆（中級）
 */
public class Challenge04_StudentManagement {

    public static void main(String[] args) {
        // バグ1: privateフィールドに直接アクセスしようとしている
        Student student1 = new Student("太郎", 20);
        System.out.println("学生名: " + student1.name);  // コンパイルエラー

        Student student2 = new Student("花子", 21);
        student2.addScore(85);
        student2.addScore(90);
        student2.addScore(78);

        student2.displayInfo();

        // バグ2: 文字列の比較に == を使っている
        Student student3 = new Student("太郎", 20);
        if (student1.getName() == student3.getName()) {
            System.out.println("同じ名前です");
        }

        // バグ3: nullチェックをしていない
        Student student4 = null;
        System.out.println("学生4の年齢: " + student4.getAge());
    }
}

class Student {
    // バグ4: カプセル化されていない（publicフィールド）
    public String name;
    public int age;
    private int[] scores;
    private int scoreCount;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.scores = new int[10];
        this.scoreCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addScore(int score) {
        // バグ5: 配列の範囲チェックをしていない
        scores[scoreCount] = score;
        scoreCount++;
    }

    public double getAverage() {
        // バグ6: scoreCountが0の時にゼロ除算が発生する
        int sum = 0;
        for (int i = 0; i < scoreCount; i++) {
            sum += scores[i];
        }
        return sum / scoreCount;
    }

    public void displayInfo() {
        System.out.println("名前: " + name);
        System.out.println("年齢: " + age);
        System.out.println("成績数: " + scoreCount);

        // バグ7: 平均が整数で表示される
        System.out.println("平均点: " + getAverage());
    }
}

/**
 * ヒント:
 * 1. privateフィールドにはgetterメソッドでアクセスします
 * 2. 文字列の比較には equals() メソッドを使います
 * 3. nullオブジェクトのメソッドを呼ぶとNullPointerExceptionが発生します
 * 4. フィールドは private にしてカプセル化しましょう
 * 5. 配列に追加する前に scoreCount < scores.length をチェックします
 * 6. ゼロ除算を防ぐため、scoreCount > 0 を確認します
 * 7. 整数の割り算は切り捨てられます。doubleにキャストしましょう
 */
