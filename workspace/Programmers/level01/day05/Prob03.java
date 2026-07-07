package level01.day05;

public class Prob03 {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if((a != b ) && (b != c) && (c != a)){ // 3개의 수가 모두 다름
            answer = a + b + c;
        } else if((a == b ) && (b == c)) { // 3개의 수가 모두 같음
            answer = (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        } else { // 2개의 수가 같고 하나가 다름
            answer = (a + b + c) * (a*a + b*b + c*c);
        }
        return answer;
    }
}
