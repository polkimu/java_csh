package level02.day06;

public class Prob01 {
    public String solution(String my_string) {
        StringBuffer answer = new StringBuffer(my_string);
        return answer.reverse().toString();
    }
}
