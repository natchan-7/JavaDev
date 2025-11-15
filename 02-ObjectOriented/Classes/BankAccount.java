package Classes;

/**
 * BankAccount.java
 * カプセル化と情報隠蔽を学習するサンプル
 * 銀行口座のシミュレーション
 */
public class BankAccount {
    // privateフィールド（外部から直接アクセス不可）
    private String accountNumber;
    private String ownerName;
    private double balance;

    // コンストラクタ
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance >= 0 ? initialBalance : 0;
    }

    // 入金
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "円を入金しました");
            displayBalance();
        } else {
            System.out.println("入金額は正の数である必要があります");
        }
    }

    // 出金
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("出金額は正の数である必要があります");
        } else if (amount > balance) {
            System.out.println("残高不足です");
        } else {
            balance -= amount;
            System.out.println(amount + "円を出金しました");
            displayBalance();
        }
    }

    // 残高照会
    public double getBalance() {
        return balance;
    }

    // 残高表示
    public void displayBalance() {
        System.out.println("現在の残高: " + balance + "円");
    }

    // 口座情報表示
    public void displayAccountInfo() {
        System.out.println("=== 口座情報 ===");
        System.out.println("口座番号: " + accountNumber);
        System.out.println("名義人: " + ownerName);
        System.out.println("残高: " + balance + "円");
    }

    // Getter（読み取り専用）
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // メインメソッド（テスト用）
    public static void main(String[] args) {
        // 銀行口座の作成
        BankAccount account = new BankAccount("123-456-789", "山田太郎", 10000);

        account.displayAccountInfo();
        System.out.println();

        // 入金
        account.deposit(5000);
        System.out.println();

        // 出金
        account.withdraw(3000);
        System.out.println();

        // 残高以上の出金を試みる
        account.withdraw(20000);
        System.out.println();

        // 最終的な口座情報
        account.displayAccountInfo();

        // balance フィールドは private なので直接アクセスできない
        // account.balance = 1000000; // コンパイルエラー
        // getterを通してのみアクセス可能
        System.out.println("\n現在の残高: " + account.getBalance() + "円");
    }
}
