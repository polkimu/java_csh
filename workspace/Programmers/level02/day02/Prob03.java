package level02.day02;

import java.util.Arrays;

public class Prob03 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numerSum, denomSum;
        numerSum = numer1*denom2 + numer2*denom1;
        denomSum = denom1*denom2;
        int gcd = gcd(numerSum, denomSum);
        numerSum /= gcd;
        denomSum /= gcd;
        int[] answer = {numerSum, denomSum};
        return answer;
    }

    public int gcd(int a, int b){
        if(b==0){
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    void main(){
        int[] arr = new int[2];
        arr = solution(324, 32, 43, 664);
        System.out.println(Arrays.toString(arr));
    }
}
