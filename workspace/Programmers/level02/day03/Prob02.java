package level02.day03;

import java.util.Arrays;

public class Prob02 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        answer=array[array.length/2];
        return answer;
    }
}
