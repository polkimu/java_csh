package level01.day05;

public class Prob01 {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int i=0; i<code.length(); i++){
            if(mode == 0){ // i가 짝수일 때만 맨 뒤에 추가
                if(code.charAt(i)=='1') mode=1;
                else {
                    if(i%2==0) answer+=code.charAt(i);
                }
            } else { // i가 홀수일 때만 맨 뒤에 추가
                if(code.charAt(i)=='1') mode=0;
                else{
                    if(i%2==1) answer+=code.charAt(i);
                }
            }
        }
        if(answer.isEmpty()) answer="EMPTY";
        return answer;
    }

    void main(){
        System.out.println(solution("abc1abc1abc"));
    }
}
