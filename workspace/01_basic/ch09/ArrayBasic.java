package ch09;

public class ArrayBasic {
    public static void main(String[] args) {
        //scores int 배열 선언, 생성 (크기 3)
        int[] scores = new int[3];
        //names String 배열 선언, 생성 (크기 5)
        String[] names = new String[5];
        //scores 배열의 각 요소에 값을 할당
        scores[0] = 0;
        scores[1] = 1;
        scores[2] = 2;
        //names 배열의 각 요소에 값을 할당
        names[0] = "a";
        names[1] = "b";
        names[2] = "c";
        names[3] = "d";
        names[4] = "e";
        //scores 배열의 두번째 요소 값 출력
        System.out.println(scores[1]);
        //names 배열의 모든 요소 값 출력
//        System.out.println(names[0]);
//        System.out.println(names[1]);
//        System.out.println(names[2]);
//        System.out.println(names[3]);
//        System.out.println(names[4]);
        for(int i=0; i<5; i++){
            System.out.println(names[i]);
        }
    }
}
