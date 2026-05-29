package ch10;

import java.util.Arrays;

public class ArrayCopyMethod {

    //전달받은 배열의 모든 요소를 출력
    static void printArr(int[] arr, String name){
        System.out.println(name + ": ");
        //original, shallow의 모든 요소 출력
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //원본 배열과 복사 배열을 출력한 후 값을 수정하고 다시 출력
    static void testArr(int[] original, int[] shallow) {
        printArr(original,"원본 배열");
        printArr(shallow, "복사 배열");

        //shallow[0]의 값을 수정
        shallow[0] = 99;
        original[0] = 88;

        //original, shallow의 모든 요소 출력
        printArr(original,"원본 배열");
        printArr(shallow, "복사 배열");
    }
    static void main(String[] args) {
        //1. 얕은 복사(shallow copy)
        System.out.println("--1.얕은 복사--");
        int [] original = {10, 20, 30};
        int [] shallow = original; // original 복사
        testArr(original,shallow);

        //깊은 복사 - 수동 복사 (for문 사용)
        System.out.println("--2.깊은 복사 - 수동 복사(for문 사용)--");
        original = new int[]{10, 20, 30}; // 배열 선언과 함께 초기화 해야함
        // 이미 선언된 변수에 새로운 배열을 할당하려면 반드시 이렇게

        shallow = new int[original.length];
        for(int i=0; i< original.length; i++) {
            shallow[i] = original[i];
        }

        testArr(original,shallow);

        // 3. 깊은 복사 (System.arraycopy() 이용)
        System.out.println("--3. 깊은 복사 (System.arraycopy()) 이용)--");
        original = new int[] {10, 20, 30, 40, 50};
        shallow=new int[original.length];
//original 1,  shallow 1 5
        System.arraycopy(original, 0, shallow,0, original.length);

        testArr(original,shallow);

        // 4. 깊은 복사 (Arrays.copyOf()이용)
        System.out.println("--4. 깊은 복사 (Arrays.copyOf()이용)--");
        original=new int[] {10, 20, 30, 40, 50};
        shallow = Arrays.copyOf(original,original.length);

        testArr(original,shallow);
    }
}

