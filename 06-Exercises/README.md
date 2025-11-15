# バグ修正チャレンジ - 練習問題集

デバッグスキルを養うための練習問題集です。各問題にはわざとバグが含まれています。すべてのバグを見つけて修正してください。

## 難易度レベル

- ★☆☆☆☆ 初級: Java基礎レベル
- ★★☆☆☆ 初級〜中級: 配列、制御構文
- ★★★☆☆ 中級: オブジェクト指向
- ★★★★☆ 中級〜上級: Spring Boot

## 練習問題一覧

### 📁 Basics（Java基礎）

#### Challenge01_Calculator.java
**難易度**: ★☆☆☆☆
**バグ数**: 5個
**学習内容**:
- 文字列連結 vs 数値演算
- 演算子の使い方
- データ型の扱い
- 変数名のタイポ
- ゼロ除算チェック

**実行方法**:
```bash
cd /home/user/JavaDev/06-Exercises/Basics
javac Challenge01_Calculator.java
java Challenge01_Calculator
```

#### Challenge02_ArrayProcessor.java
**難易度**: ★★☆☆☆
**バグ数**: 4個
**学習内容**:
- 配列の範囲外アクセス
- ループの境界条件
- 整数除算 vs 浮動小数点除算
- 初期値の設定

**実行方法**:
```bash
javac Challenge02_ArrayProcessor.java
java Challenge02_ArrayProcessor
```

#### Challenge03_GradeCalculator.java
**難易度**: ★★☆☆☆
**バグ数**: 6個
**学習内容**:
- if-else文の条件範囲
- switch文のbreak
- 論理条件の評価
- 平均値の計算

**実行方法**:
```bash
javac Challenge03_GradeCalculator.java
java Challenge03_GradeCalculator
```

---

### 📁 OOP（オブジェクト指向プログラミング）

#### Challenge04_StudentManagement.java
**難易度**: ★★★☆☆
**バグ数**: 7個
**学習内容**:
- カプセル化（private/public）
- getter/setterの使い方
- 文字列比較（== vs equals）
- nullチェック
- 配列の境界チェック
- ゼロ除算エラー

**実行方法**:
```bash
cd /home/user/JavaDev/06-Exercises/OOP
javac Challenge04_StudentManagement.java
java exercises.Challenge04_StudentManagement
```

#### Challenge05_ShapeHierarchy.java
**難易度**: ★★★☆☆
**バグ数**: 6個
**学習内容**:
- 継承とポリモーフィズム
- 抽象クラス・抽象メソッド
- 親クラスのコンストラクタ呼び出し
- 型キャスト
- instanceof演算子

**実行方法**:
```bash
javac Challenge05_ShapeHierarchy.java
java exercises.Challenge05_ShapeHierarchy
```

---

### 📁 SpringBoot（Spring Boot REST API）

#### Challenge06_BookAPI.java
**難易度**: ★★★★☆
**バグ数**: 8個
**学習内容**:
- @RestController アノテーション
- @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
- @PathVariable, @RequestBody
- エンドポイントの重複
- getter/setterの実装

**実行方法**:
```bash
# このファイルはSpring Bootプロジェクト内で実行する必要があります
cd /home/user/JavaDev/java-learning/src/main/java/com/learning
# Challenge06_BookAPI.java を配置して実行
mvn spring-boot:run
```

**テスト方法**:
```bash
# GET: 全書籍取得
curl http://localhost:8080/api/books

# GET: 特定書籍取得
curl http://localhost:8080/api/books/1

# POST: 新規書籍作成
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"新しい本","author":"著者名","price":3000}'

# PUT: 書籍更新
curl -X PUT http://localhost:8080/api/books/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"更新された本","author":"著者名","price":3500}'

# DELETE: 書籍削除
curl -X DELETE http://localhost:8080/api/books/1
```

---

## 学習の進め方

### 1. 問題を読む
まず、期待される動作を理解しましょう。

### 2. コードを実行する
エラーメッセージや異常な動作を確認します。

### 3. バグを探す
- コンパイルエラー
- ランタイムエラー
- 論理エラー（動くけど結果が間違っている）

### 4. ヒントを参考にする
各ファイルの最後にヒントが記載されています。

### 5. 修正して確認
バグを修正したら、再度実行して正しく動作するか確認します。

### 6. 解答例と比較（オプション）
`Solutions/` ディレクトリに解答例があります（今後追加予定）。

## デバッグのコツ

### エラーメッセージを読む
- コンパイルエラーは行番号を教えてくれます
- 例外メッセージは何が問題かを示しています

### print文でデバッグ
```java
System.out.println("変数の値: " + variable);
```

### 小さく分けて確認
- 一度に全部修正しようとせず、1つずつバグを直します
- 修正するたびに実行して確認します

### よくあるバグパターン

1. **配列の範囲外アクセス**
   ```java
   // ❌ 間違い
   for (int i = 0; i <= array.length; i++)

   // ✅ 正しい
   for (int i = 0; i < array.length; i++)
   ```

2. **文字列比較**
   ```java
   // ❌ 間違い
   if (str1 == str2)

   // ✅ 正しい
   if (str1.equals(str2))
   ```

3. **整数除算**
   ```java
   // ❌ 間違い（結果が切り捨てられる）
   int average = sum / count;

   // ✅ 正しい
   double average = (double) sum / count;
   ```

4. **nullチェック忘れ**
   ```java
   // ❌ 間違い
   object.method();  // objectがnullならNullPointerException

   // ✅ 正しい
   if (object != null) {
       object.method();
   }
   ```

## 次のステップ

1. すべての練習問題を解く
2. 自分でバグを含むコードを作成して、友人に解いてもらう
3. 実際のプロジェクトでデバッグスキルを活用する

## フィードバック

これらの練習問題で学んだことを実際のコードに活かしてください。デバッグは開発の重要なスキルです！
