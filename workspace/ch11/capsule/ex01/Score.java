package ch11.capsule.ex01;

public class Score {
    int kor;
    int eng;
    int math;

    //총점을 게산해서 반환
    //캡슐화를 통해서 불필요한 함수 호출을 방지
    private int sum(){
        return kor + eng + math;
    }

    //평균을 계산해서 반환 (소수 셋째 자리에서 반올림)
    double avg(){
        return Math.round(sum() / 3.0 * 100) / 100.0;
    }
}
