package level02.day06;

public class Prob03 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int numOdd=0;
        int numEven=0;
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0) numEven++;
            else numOdd++;
        }
        answer[0]=numEven;
        answer[1]=numOdd;
        return answer;
    }
}
