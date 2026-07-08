package level01.day06;

public class Prob01 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        for(int i=0; i<num_list.length; i++){
            answer[i]=num_list[i];
        }
        if(num_list[num_list.length-1]>num_list[num_list.length-2]){ // 마지막 원소가 그 전 원소보다 크면
            answer[num_list.length] = num_list[num_list.length-1]-num_list[num_list.length-2];
        } else {
            answer[num_list.length] = num_list[num_list.length-1] * 2;
        }
        return answer;
    }
}
