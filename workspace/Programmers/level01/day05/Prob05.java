package level01.day05;

public class Prob05 {
    public int solution(int[] num_list) {
        int sumEven=0;
        int sumOdd=0;
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){ // 짝수라면
                sumEven*=10;
                sumEven+=num_list[i];
            } else { // 홀수라면
                sumOdd*=10;
                sumOdd+=num_list[i];
            }
        }
        return sumEven+sumOdd;
    }
}
