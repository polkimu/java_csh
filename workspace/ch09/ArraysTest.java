package ch09;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] arr={3,6,7,8,5,3,5,6,8,2,3,2};

        //1. arr의 모든 요소 출력
        for(int i : arr){
            System.out.println(i);
        }

        System.out.println(Arrays.toString(arr));
        //2. arr2와 arr3, arr4의 모든 요소가 같은 값인지 출력(순서와 값이 모두 일치)
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {2, 1, 3};
        int[] arr4 = {1, 2, 3};
        boolean same = true;
        for(int i=0; i<arr2.length; i++) {
            if(arr2[i]!=arr3[i]){
                same = false;
                break;
            }
        }
        if(same==true) {
            System.out.println("arr2 arr3 같음");
        }
        else System.out.println("arr2 arr3 다름");

        same = true;
        //arr2, arr4
        for(int i=0; i<arr2.length; i++) {
            if(arr2[i]!=arr4[i]){
                same = false;
                break;
            }
        }
        if(same==true) {
            System.out.println("arr2 arr4 같음");
        }
        else System.out.println("arr2 arr4 다름");

        //3. arr요소의 최소값과 최대값을 구하세요.
        int max = arr[0];
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if (arr[i]>max) {
                max=arr[i];
            }
            if (arr[i]<min) {
                min=arr[i];
            }
        }
        System.out.println("최대 " + max + " 최소 " + min);
        //4. arr의 요소를 오름차순으로 정렬
        min = 10;
        int temp; // swap을 위한 임시 변수
        int minIndex; // 최소값의 인덱스를 기억

        // 0에서 마지막 값 사이에서 min값을 찾아서 arr[0]에, 그 다음 1에서 마지막 값 사이의 min값을 찾아서 arr[1]에...
        for(int i=0; i<arr.length-1; i++){ // i번째 에서는
            minIndex = i;
            for(int k = i+1; k<arr.length; k++){ //i에서 마지막 값 사이의 min 값을 탐색
                if (arr[k]<arr[minIndex]) {//min 값을 찾았을 때
                    minIndex=k; // 최소값 인덱스 저장
                }
            }
            temp=arr[i]; // arr[i]와 arr[minIndex]의 값을 swap
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;;
        }
        System.out.println(Arrays.toString(arr));

        for(int i=0; i<arr.length; i++){
            for(int k=i; k<arr.length-1; k++){
                if(arr[i]>arr[k+1]){
                    temp=arr[i];//swap
                    arr[i]=arr[k+1];
                    arr[k+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
