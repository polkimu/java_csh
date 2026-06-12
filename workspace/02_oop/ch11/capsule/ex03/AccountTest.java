package ch11.capsule.ex03;

public class AccountTest {
    public static void main(String[] args) {
        Account myAccount = new Account();

        //amount 원이 입금되었습니다. 잔고는 balance 원 입니다.
        myAccount.deposit(8000);
        //amount 원이 출금되었습니다. 잔고는 balance 원 입니다.
        myAccount.withdraw(5000);
        //잔고가 부족합니다. 잔고는 balance 원 입니다.
        myAccount.withdraw(10000);

        //잔고 출력
        System.out.println("현재 잔고 : " + myAccount.getBalance());
    }
}
