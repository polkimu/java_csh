package level01.day07;

import java.util.ArrayList;

public class Prob04 {
    public int[] solution(int n) {
        int[] tmp = new int[1000000];
        int arrayLength = 0;

        while(n!=1){
            tmp[arrayLength] = n;
            arrayLength++;
            if(n%2==0) n/=2;
            else n=3*n+1;
        }
        tmp[arrayLength]=1;
        arrayLength++;
        int[] answer = new int[arrayLength];
        for(int i=0; i<arrayLength; i++){
            answer[i]=tmp[i];
        }
        return answer;
    }
}
