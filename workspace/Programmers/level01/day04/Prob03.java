package level01.day04;

public class Prob03 {
    public int solution(int n) {
        int answer = 0;
        if(n%2 == 0) answer = sumEven(n);
        else answer = sumOdd(n);
        return answer;
    }

    public int sumOdd(int a){
        int sum = 0;
        for(int i=1; i<=a; i+=2) {
            sum+=i;
        }
        return sum;
    }

    public int sumEven(int a) {
        int sum=0;
        for(int i=0; i<=a; i+=2){
            sum+=i*i;
        }
        return sum;
    }
}
