package level01.day07;

public class Prob02 {
    public int[] solution(int l, int r) {
        int[] tmp = new int[1000001];
        int arrayLength = 0;
        for(int i=l; i<=r; i++){
            if(is0or5(i)){
                tmp[arrayLength]=i;
                arrayLength++;
            }
        }
        int[] answer = new int[arrayLength];
        for(int i=0; i<arrayLength; i++){
            answer[i]=tmp[i];
        }
        if(answer.length==0){
            int[] nullArray = new int[]{-1};
            return nullArray;
        }
        return answer;
    }

    public boolean is0or5(int n){ // 각 자리수가 5의 배수인지 검사
        while(n!=0){
            if(n%5!=0) return false;
            else{
                n/=10;
            }
        }
        return true;
    }
}
