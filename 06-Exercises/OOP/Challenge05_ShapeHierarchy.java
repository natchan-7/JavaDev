package exercises;

/**
 * Challenge05_ShapeHierarchy.java
 * バグ修正チャレンジ: 図形の継承システム
 *
 * 【問題】
 * このプログラムには6つのバグがあります。すべて見つけて修正してください。
 *
 * 【期待される動作】
 * 1. 各図形の面積を正しく計算する
 * 2. ポリモーフィズムを使って異なる図形を統一的に扱う
 * 3. 親クラスのコンストラクタを適切に呼び出す
 *
 * 【難易度】★★★☆☆（中級）
 */
public class Challenge05_ShapeHierarchy {

    public static void main(String[] args) {
        // バグ1: 型が間違っている（ポリモーフィズムを使うべき）
        Rectangle rect = new Rectangle(5, 10);
        Circle circle = new Circle(7);
        Triangle triangle = new Triangle(6, 8);

        // ポリモーフィズムの例（これは正しい）
        Shape[] shapes = {rect, circle, triangle};

        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println();
        }

        // バグ2: キャストの型チェックをしていない
        Shape s = new Circle(5);
        Rectangle r = (Rectangle) s;  // ClassCastException
        System.out.println("矩形の幅: " + r.getWidth());
    }
}

class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // バグ3: このメソッドは抽象メソッドであるべき
    public double getArea() {
        return 0;  // 意味のない実装
    }

    public void displayInfo() {
        System.out.println("図形: " + name);
        System.out.println("面積: " + getArea());
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    // バグ4: 親クラスのコンストラクタを呼んでいない
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getArea() {
        // バグ5: 計算式が間違っている
        return width + height;  // 正しくは width * height
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("円");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        // バグ6: 円周率の精度が低い
        return 3.14 * radius * radius;  // Math.PIを使うべき
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super("三角形");
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}

/**
 * ヒント:
 * 1. ポリモーフィズムを使う場合、親クラス型で宣言します
 * 2. キャストする前に instanceof で型チェックをします
 * 3. Shapeクラスは abstract class にして、getArea()を abstract method にすべきです
 * 4. super(name) で親クラスのコンストラクタを呼び出します
 * 5. 矩形の面積は 幅 × 高さ です
 * 6. 円周率は Math.PI を使いましょう（3.141592...）
 *
 * 期待される出力:
 * 図形: 矩形
 * 面積: 50.0
 *
 * 図形: 円
 * 面積: 153.93804002589985
 *
 * 図形: 三角形
 * 面積: 24.0
 */
