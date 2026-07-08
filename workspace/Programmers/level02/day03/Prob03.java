package level02.day03;

import java.util.Arrays;

class Prob03 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int max = 0; // 최대 나온 빈도를 저장
        int count = 1; // 현재
        boolean check = false; // 최빈값이 여러개인지
        int freq = 0; // 최빈값
        if(array.length == 1) return array[0];
        for(int i=1; i<array.length; i++){
            if(array[i-1]==array[i]) {
                count++;
            }
            else {
                if(max<count) {
                    max=count;
                    check = false;
                    freq = array[i-1];
                } else if(max==count) {
                    check = true;
                }
                count = 1;
            }
        }
        if(max<count) {
            max=count;
            check = false;
            freq = array[array.length-1];
        } else if(max==count) {
            check = true;
        }
        if(check == true) answer = -1;
        else answer = freq;
        return answer;
    }
}
