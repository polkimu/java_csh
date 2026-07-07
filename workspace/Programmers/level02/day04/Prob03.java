package level02.day04;

public class Prob03 {
    public int solution(int slice, int n) {
        int answer = 0;
        answer = (n-1)/slice + 1;
        return answer;
    }
}
