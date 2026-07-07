package level01.day03;

public class Prob05 {
    public int solution(int a, int b) {
        int answer = 0;
        if(operation(a,b)>=2*a*b) answer=operation(a,b);
        else answer=2*a*b;
        return answer;
    }

    public int operation(int a, int b){
        int aTimes = 1; // b의 자릿수에 따라 a에 10의 n승을 곱해야 함
        int tmp = b;
        while(tmp!=0){
            tmp /= 10;
            aTimes*=10;
        }
        return a*aTimes+b;
    }
}
