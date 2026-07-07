package level02.day05;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Prob04 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i=0; i<num_list.length; i++){
            answer[i]=num_list[num_list.length-i-1];
        }
        return answer;
    }
}
