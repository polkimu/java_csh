package ch09;

import java.util.Scanner;
//구구단 결과를 배열로 저장
public class ArrayForTest4 {
    public static void main(String[] args) {
        System.out.println("단을 입력하세요");
        Scanner s = new Scanner(System.in);
        int dan = s.nextInt();
        int num = 1;
        int[] result = new int[9];

        for(int i = 0; i < result.length; i++){
            result[i] = dan*(i+1);
        }

        System.out.println(dan + "단 학습 완료");

        // 0을 입력할때 까지 무한으로 반복
        while(true) {
            System.out.println("곱할 숫자 입력(0입력시 종료)");
            num = s.nextInt();
            if (num == 0) break;
            System.out.println(dan + " x " + num + " = " + result[num - 1]);
        }
    }
}