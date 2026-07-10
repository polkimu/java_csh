package level01.day07;

public class Prob03 {
    public int[] solution(int start_num, int end_num) {
        int[] tmp = new int[51];
        int arrayLength = 0;
        for(int i=start_num; i<=end_num; i++){
            tmp[arrayLength]=i;
            arrayLength++;
        }
        int[] answer = new int[arrayLength];
        for(int i=0; i<arrayLength; i++){
            answer[i]=tmp[i];
        }
        return answer;
    }
}
