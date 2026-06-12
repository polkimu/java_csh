package ch08;

public class ForTest7 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1; i<=100; i++){
            if(i % 2 == 0){ //짝수일 때
                continue;
            }
            sum += i;
        }
        System.out.println("1~100 홀수 합계: " + sum);
    }
}
