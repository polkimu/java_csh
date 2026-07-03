package level02.day03;

public class Prob04 {
    public int[] solution(int n) {
        int[] answer = new int[(n+1)/2];
        int index = 0;
        for(int i=1; i<=n; i+=2){
            answer[index] = i;
            index++;
        }
        return answer;
    }
}
