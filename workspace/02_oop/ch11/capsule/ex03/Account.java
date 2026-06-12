package ch11.capsule.ex03;

public class Account {
    //잔고
    private int balance;

    public int getBalance() {
        return balance;
    }

    //입금 (amount 만큼 balance 증가)
    public void deposit(int amount){
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 잔고는 " + balance + "원 입니다.");
    }

    //출금 (amount 만큼 balance 감소. 단, 잔고가 부족한지 체크 필요)
    public void withdraw(int amount){
        if (balance < amount) {
            System.out.println("잔고가 부족합니다. 잔고는 " + balance + "원 입니다.");
        }
        else {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 잔고는 " + balance + "원 입니다.");
        }
    }
}
