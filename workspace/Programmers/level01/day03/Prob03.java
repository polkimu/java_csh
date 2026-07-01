package level01.day03;

public class Prob03 {
    public String solution(String my_string, int k) {
        String answer = "";
        for(int i=0; i<k; i++){
            answer+=my_string;
        }
        return answer;
    }

    void main(){
        System.out.println(solution("love", 10));
    }
}
