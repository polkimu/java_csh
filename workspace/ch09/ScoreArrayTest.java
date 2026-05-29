package ch09;

//국어, 영어, 수학 점수를 이용해서 총점과 평균 계산
public class ScoreArrayTest {
    public static void main(String[] args) {
        int kor = 100;
        int eng = 90;
        int math = 85;

//        int[] haruScore;
//        haruScore = new int[3]; // 배열 생성 (개수 지정)
//        haruScore[0] = 100;
//        haruScore[1] = 90;
//        haruScore[2] = 85;
        int haruScore[] = new int[]{100, 90, 85};
        System.out.println("국어 : " + haruScore[0]); // 100
        System.out.println("영어 : " + haruScore[1]); // 90
        System.out.println("수학 : " + haruScore[2]); // 85
        int sum = haruScore[0] + haruScore[1] + haruScore[2];//총점
        double avg = sum / 3.0; // 평균, 91.66666
        //avg = Math.round(avg); // 소수 첫째자리에서 반올림, 92
        avg = Math.round(avg * 10) / 10.0; // 소수 둘째자리에서 반올림, 91.7

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
