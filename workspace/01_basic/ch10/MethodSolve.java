package ch10;

public class MethodSolve {
    //int[] 점수를 전달 받아서 총점을 계산해서 반환 메서드
    int sum(int[] scores){
        int total = 0;
        for(int score : scores){
            total += score;
        }
        return total;
    }

    //int 총점을 전달 받아서 평균을 계산해서 반환하는 메서드
    double avg(int total, int arrLength){
        return Math.round((double)total * 10 / arrLength) / 10.0; // 소수 첫째자리에서 반올림
    }

    //int[] 점수를 전달 받아서 총점, 평균을 출력하는 메서드
    void printScore(int[] scores){
        System.out.print("총점: " + sum(scores) + " "); // 총점 출력
        System.out.println("평균: " + avg(sum(scores), scores.length));
    }

    //전체 총점과 평균 출력
    void printAllScore(){

    }

    void main() {
        // haru는 국어, 영어, 수학 점수가 각각 80, 70, 56이다
        // namu는 국어, 영어, 수학 점수가 각각 90, 77, 80이다
        // brong은 국어, 영어, 수학 점수가 각각 100, 99, 88이다

        // 이 셋의 총점과 평균을 구해서 출력 하세요
        int[] haruScore = {80, 70, 56};
        int[] namuScore = {90, 77, 80};
        int[] brongScore = {100, 99, 88};
        printScore(haruScore);
        printScore(namuScore);
        printScore(brongScore);
    }
}
