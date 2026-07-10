package level01.day07;

import java.util.ArrayList;

public class Prob05 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
        for(int i=0; i<arr.length;){
            if(stk.isEmpty()){
                stk.add(arr[i]);
                i++;
            } else if(stk.getLast()<arr[i]){
                stk.add(arr[i]);
                i++;
            } else if(stk.getLast()>=arr[i]){
                stk.remove(stk.getLast());
            }
        }

        int[] answer = new int[stk.size()];
        for(int i=0; i<stk.size(); i++){
            answer[i]=stk.get(i);
        }
        return answer;
    }
}
