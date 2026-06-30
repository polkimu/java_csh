package level01.day02;

public class Prob05 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int index=s;
        for(int i=0; i<s; i++){
            answer += my_string.charAt(i);
        }
        for(int i=0; i<overwrite_string.length(); i++){
            answer += overwrite_string.charAt(i);
            index++;
        }
        for(int i=index; i<my_string.length(); i++){
            answer += my_string.charAt(i);
        }
        return answer;
    }
}
