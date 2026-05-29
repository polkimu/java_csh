package ch08;

//첫 달에 1원, 매달 두배씩
//몇달이 지나야 1억?
public class WhileTest2 {
    public static void main(String[] args) {
        int month = 1;
        int sal = 1;

        while(sal<100000000) { // 월급이 1억을 넘기는 달을 찾으려고 함 month = 1 month =2 salary =2 .....
            month++;
            sal *= 2;
        }
        System.out.println(month+"달의 급여"+sal);
    }
}
