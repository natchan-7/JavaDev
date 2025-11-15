# Spring Boot 学習ガイド

## はじめに

このディレクトリにはSpring Boot Web開発の基礎を学ぶためのサンプルコードが含まれています。

## 前提条件

- Java 21以上
- Maven
- IntelliJ IDEA または VS Code

## Spring Bootとは

Spring Bootは、Javaで本格的なWebアプリケーションを簡単に構築できるフレームワークです。

### 主な特徴

1. **設定の簡略化**: XML設定が不要、アノテーションベース
2. **組み込みサーバー**: Tomcatなどが組み込まれており、jarファイル単体で実行可能
3. **自動設定**: 必要な設定を自動で行う
4. **豊富なスターター**: データベース、セキュリティなど、機能ごとにパッケージ化

## サンプルファイル

### 1. SpringBootBasicsApp.java

REST APIの基礎を学ぶサンプル

**学習内容:**
- `@SpringBootApplication`: アプリケーションのエントリーポイント
- `@RestController`: REST APIコントローラー
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: HTTPメソッド
- `@RequestParam`: クエリパラメータ
- `@PathVariable`: パスパラメータ
- `@RequestBody`: リクエストボディ

**実行方法:**

```bash
# プロジェクトルートで実行
cd /home/user/JavaDev/java-learning
mvn spring-boot:run
```

**APIテスト:**

```bash
# GETリクエスト
curl http://localhost:8080/api/greeting
curl http://localhost:8080/api/greeting?name=Taro
curl http://localhost:8080/api/users
curl http://localhost:8080/api/users/1

# POSTリクエスト（新規ユーザー作成）
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"id": 4, "name": "田中次郎", "email": "tanaka@example.com"}'

# PUTリクエスト（ユーザー更新）
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "name": "山田太郎（更新）", "email": "yamada_new@example.com"}'

# DELETEリクエスト（ユーザー削除）
curl -X DELETE http://localhost:8080/api/users/1
```

## 学習ステップ

### ステップ1: 基本的なREST API

1. `SpringBootBasicsApp.java`を実行
2. ブラウザまたはcurlでAPIにアクセス
3. レスポンスの形式を確認

### ステップ2: HTTPメソッドの理解

- **GET**: データの取得
- **POST**: 新規データの作成
- **PUT**: データの更新
- **DELETE**: データの削除

### ステップ3: パラメータの受け取り方

1. **クエリパラメータ**: `?name=value`
   - `@RequestParam`を使用

2. **パスパラメータ**: `/users/1`
   - `@PathVariable`を使用

3. **リクエストボディ**: JSON形式のデータ
   - `@RequestBody`を使用

## 次のステップ

1. **データベース連携**: Spring Data JPAを使った永続化
2. **バリデーション**: 入力値の検証
3. **例外ハンドリング**: エラーレスポンスの統一
4. **セキュリティ**: Spring Securityによる認証・認可
5. **テスト**: JUnitとMockitoを使ったテスト

## 参考リソース

- [Spring Boot公式ドキュメント](https://spring.io/projects/spring-boot)
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Initializr](https://start.spring.io/) - プロジェクトの雛形生成

## トラブルシューティング

### ポートが既に使用されている

```
Error: Port 8080 is already in use
```

**解決方法:**
1. 既存のプロセスを停止する
2. または、`application.properties`でポートを変更:

```properties
server.port=8081
```

### 依存関係のエラー

```bash
# Mavenの依存関係を再ダウンロード
mvn clean install
```
