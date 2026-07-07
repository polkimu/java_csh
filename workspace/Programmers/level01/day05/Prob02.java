package level01.day05;

public class Prob02 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i=0; i<included.length; i++){
            if(included[i]){
                answer += a + i*d;
            }
        }
        return answer;
    }
}
