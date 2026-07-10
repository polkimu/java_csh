package level01.day07;

public class Prob01 {
    public int[] solution(int[] arr, int[][] queries) {
        int s, e, k;
        for(int i=0; i<queries.length; i++){ // i : query의 index
            s = queries[i][0];
            e = queries[i][1];
            k = queries[i][2];
            for(int j=s; j<=e; j++){ // j : arr의 index
                if(j%k == 0){
                    arr[j]++;
                }
            }
        }
        return arr;
    }
}
