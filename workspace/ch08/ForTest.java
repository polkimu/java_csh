package ch08;

public class ForTest {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int sum = 0;

        for(int i=1;i<=num;i++){
            sum+=i; //i를 계속 더함
            System.out.println("i: " + i + ", sum: " + sum);
        }
        System.out.println(sum);
    }
}
