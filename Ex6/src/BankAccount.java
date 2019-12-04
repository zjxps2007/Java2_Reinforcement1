import java.util.Random;

class BankAccount {
    int balance = 0;

    public synchronized void withdraw(int money) {
        if (money > 0 && balance >= money) {
            balance -= money;
            System.out.printf("%d 인률하여 현재 잔고 %d 입니다.\n",money,balance);
        }
        else if (balance < money) {
            System.out.println("잔고가 부족하여 인출할 수 없습니다.");
        }
    }
    public synchronized void deposit(int money) {
        if(money > 0) {
            balance += money;
            System.out.printf("%d 입금하여 현재 잔고 %d 입니디.\n",money,balance);
        }
    }
}
class MyThread implements Runnable {
    BankAccount act;

    public MyThread(BankAccount a) {
        act = a;
    }

    public void run() {
        int amount;
        for (int i = 0; i < 3; i++) {
            amount = new Random().nextInt(10000);
            amount = amount % 10 * 1000;
            act.deposit(amount);
            amount = new Random().nextInt(10000);
            amount = amount % 10 * 1000;
            act.withdraw(amount);
        }
    }
}
class BankAccountTest {
    public static void main(String[] args) {
        BankAccount act = new BankAccount();
        Runnable r = new MyThread(act);
        new Thread(r).start();
        new Thread(r).start();
    }
}