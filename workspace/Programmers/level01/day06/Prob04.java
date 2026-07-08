package level01.day06;

public class Prob04 {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i=0; i<queries.length; i++){
            swap(arr,queries[i][0], queries[i][1]);
        }
        return arr;
    }

    public void swap(int[] arr, int aIndex, int bIndex){
        int tmp=arr[aIndex];
        arr[aIndex]=arr[bIndex];
        arr[bIndex]=tmp;
    }
}
