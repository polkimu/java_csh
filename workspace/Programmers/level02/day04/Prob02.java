package level02.day04;

public class Prob02 {
    public int solution(int n) {
        int answer = 0;
        answer=lcm(n,6)/6;
        return answer;
    }

    public int gcd(int a, int b){
        if(b==0){
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    public int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
