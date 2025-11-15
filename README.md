# Java/Spring Boot 学習プロジェクト

このプロジェクトは、JavaとSpring Bootを段階的に学習するための教育用リポジトリです。

## 環境構成

- **JDK**: OpenJDK 21
- **フレームワーク**: Spring Boot 3.2.0
- **ビルドツール**: Maven
- **バージョン管理**: Git
- **AI支援**: Claude Code
- **開発環境**: Linux/Windows/macOS

## プロジェクト構造

```
JavaDev/
├── java-learning/          # Mavenプロジェクト（Spring Boot対応）
│   ├── pom.xml            # Java 21 + Spring Boot 3.2.0
│   └── src/
│       ├── main/java/com/learning/
│       │   ├── App.java               # Spring Bootメインアプリ
│       │   └── controller/
│       │       └── HelloController.java  # REST APIサンプル
│       └── test/java/      # JUnit 5テスト
│
├── 01-Basics/              # Java基礎文法
│   ├── HelloWorld.java    # 最初のJavaプログラム
│   ├── Variables.java     # 変数とデータ型
│   ├── ControlFlow.java   # 制御構文（if, switch, for, while）
│   ├── Methods.java       # メソッド、オーバーロード、再帰
│   └── Arrays.java        # 配列操作
│
├── 02-ObjectOriented/      # オブジェクト指向プログラミング
│   ├── Classes/
│   │   ├── Person.java        # クラスの基本
│   │   └── BankAccount.java   # カプセル化
│   └── Inheritance/
│       ├── Animal.java        # 親クラス
│       ├── Dog.java          # 継承
│       ├── Cat.java          # 継承
│       └── PolymorphismDemo.java  # ポリモーフィズム
│
├── 03-WebDevelopment/      # Spring Boot Web開発
│   ├── SpringBootBasicsApp.java  # REST API基礎
│   └── README_SpringBoot.md      # Spring Boot学習ガイド
│
├── 04-Practice/            # 実践プロジェクト
│   ├── TodoApp.java       # ToDoアプリ（コンソール版）
│   └── README.md          # 実践プロジェクトガイド
│
└── 05-Portfolio/           # ポートフォリオ作品（今後追加予定）
```

## 学習ロードマップ

### 1. Java基礎（01-Basics）
- 変数とデータ型
- 制御構文（条件分岐・繰り返し）
- メソッドとオーバーロード
- 配列操作

### 2. オブジェクト指向（02-ObjectOriented）
- クラスとオブジェクト
- カプセル化
- 継承
- ポリモーフィズム

### 3. Spring Boot開発（03-WebDevelopment）
- Spring Bootの基礎
- REST APIの作成
- HTTPメソッド（GET/POST/PUT/DELETE）
- パラメータの扱い

### 4. 実践プロジェクト（04-Practice）
- ToDoアプリケーション
- CRUD操作の実装
- データ管理

### 5. ポートフォリオ作品（05-Portfolio）
- 公開可能なアプリケーション作成
- デプロイとセキュリティ対策

## クイックスタート

### 1. Spring Bootアプリの起動

```bash
cd java-learning
mvn spring-boot:run
```

ブラウザで以下にアクセス:
- http://localhost:8080/
- http://localhost:8080/hello?name=Taro
- http://localhost:8080/api/status

### 2. Java基礎サンプルの実行

```bash
cd 01-Basics
javac HelloWorld.java
java HelloWorld
```

### 3. ToDoアプリの実行

```bash
cd 04-Practice
javac TodoApp.java
java practice.TodoApp
```

## 開発フロー

1. **学習**: 各ディレクトリのサンプルコードを読む
2. **実践**: コードを実行して動作を確認
3. **カスタマイズ**: サンプルコードを改変して理解を深める
4. **テスト**: JUnitでテストを書く
5. **コミット**: Gitでバージョン管理

## Spring Boot API テスト

### curlでAPIをテスト

```bash
# GET: 挨拶メッセージ
curl http://localhost:8080/hello?name=Taro

# GET: 全ユーザー取得
curl http://localhost:8080/api/users

# POST: ユーザー作成
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"id": 4, "name": "田中次郎", "email": "tanaka@example.com"}'

# DELETE: ユーザー削除
curl -X DELETE http://localhost:8080/api/users/1
```

## 依存関係の管理

```bash
# 依存関係のダウンロード
mvn clean install

# テスト実行
mvn test

# ビルド
mvn package
```

## 学習リソース

- [Spring Boot公式ドキュメント](https://spring.io/projects/spring-boot)
- [Java公式チュートリアル](https://docs.oracle.com/javase/tutorial/)
- [Maven入門](https://maven.apache.org/guides/getting-started/)

## トラブルシューティング

### ポート8080が使用中の場合

`java-learning/src/main/resources/application.properties`を作成:
```properties
server.port=8081
```

### Javaバージョンエラー

```bash
java -version  # Java 21以上であることを確認
```

## 次のステップ

1. データベース連携（Spring Data JPA）
2. セキュリティ（Spring Security）
3. フロントエンド統合（React, Vue.js）
4. デプロイ（Docker, AWS, Heroku）
