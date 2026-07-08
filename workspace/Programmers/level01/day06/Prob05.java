package level01.day06;

public class Prob05 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int min=1000001;
        for(int i=0; i< queries.length; i++){
            min=1000001;
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            for(int j=s; j<=e; j++){ // 탐색
                if(min>arr[j]&&arr[j]>k){
                    min=arr[j];
                }
            }
            if(min==1000001) min=-1;
            answer[i]=min;
        }
        return answer;
    }
}
