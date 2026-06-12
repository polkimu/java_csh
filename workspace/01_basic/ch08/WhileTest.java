package ch08;

// 1부터 지정한 숫자까지의 합
public class WhileTest {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int i=1;// 임시 반복 횟수를 나타내는 변수
        int sum = 0;

        while (i<=num) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
}
