package level01.day08;

import java.util.function.Function;

public class Prob04 {
    public int solution(String number) {
        int answer = 0;
        int sum = 0;
        for(int i=0; i<number.length(); i++){
            sum += number.charAt(i) - 48; // Ascii code
        }
        answer = sum % 9;
        return answer;
    }

    void main(){
        System.out.println(solution("78720646226947352489"));
    }
}
