package level02.day03;

import java.util.Arrays;

public class Prob03 {
    public int solution(int[] array) {
        if (array.length == 1) return array[0];
        int answer = 0;
        int[] count = new int[array.length];
        for(int i=0; i<array.length; i++){
            count[array[i]]++;
        }
        int max = 0;
        int index = 0;
        for(int i=0; i<count.length; i++){
            if(max<count[i]) max = count[i];
            index = i;
        }
        Arrays.sort(count);

        if(count[count.length-1] == count[count.length-2]) return -1;
        else answer=count[array.length-1];
        return answer;
    }
}
