package level01.day08;

public class Prob02 {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        if((a==b) && (b==c) && (c==d)) answer=1111*a;
        else if((a==b) && (b==c)) answer = (10*a + d) * (10*a + d); // d만 다름
        else if((a==b) && (b==d)) answer = (10*a + c) * (10*a + c); // c만 다름
        else if((a==c) && (c==d)) answer = (10*a + b) * (10*a + b); // b만 다름
        else if((b==c) && (c==d)) answer = (10*b + a) * (10*b + a); // a만 다름
        else if((a==b) && (c==d)) answer = (a+c) * Math.abs(a-c);// a=b, c=d
        else if((a==c) && (b==d)) answer = (a+b) * Math.abs(a-b);// a=c,b=d
        else if((a==d) && (b==c)) answer = (a+b) * Math.abs(a-b);// a=d, c=d
        else if(a==b) answer = c*d;
        else if(a==c) answer = b*d;
        else if(a==d) answer = b*c;
        else if(b==c) answer = a*d;
        else if(b==d) answer = a*c;
        else if(c==d) answer = a*b;
        else answer = Math.min(Math.min(a,b),Math.min(c,d)); // 모두 다름
        return answer;
    }
}
