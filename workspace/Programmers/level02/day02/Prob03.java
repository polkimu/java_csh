package level02.day02;

import java.util.Arrays;

public class Prob03 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numerSum, denomSum;
        numerSum = numer1*denom2 + numer2*denom1;
        denomSum = denom1*denom2;
        for(int i=2; i<denomSum; i++){
            if(numerSum % i == 0 && denomSum % i == 0){
                numerSum /= i;
                denomSum /= i;
                i--; // 한번 더 검사해야 하기 때문 (eg. 4와 8은 2로 두번 나눌 수 있음)
            }
        }
        int[] answer = {numerSum, denomSum};
        return answer;
    }

    void main(){
        int[] arr = new int[2];
        arr = solution(324, 32, 43, 664);
        System.out.println(Arrays.toString(arr));
    }
}
