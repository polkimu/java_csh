package ch07;

//입력한 숫자가 3의 배수 : "3의 배수입니다", 그렇지 않다면 아무것도 하지 않음
public class IfTest {
    public static void main(String[] args) {
        int num = 15;

        if(num % 3 == 0){
            System.out.println("3의 배수 입니다");
        }
        else if(num % 2 == 0){
            System.out.println("짝수");
        }
        else {
            System.out.println("홀수");
        }
    }
}
