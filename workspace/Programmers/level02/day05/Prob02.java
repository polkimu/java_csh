package level02.day05;

public class Prob02 {
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0]=money/5500;
        answer[1]=money%5500;
        return answer;
    }
}
