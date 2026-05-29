package ch07;

// [문제] 시험 점수(score)에 따른 학점을 출력하는 코드를 작성하세요.
// 학점 기준:
// - 90점 이상 ~ 100점 이하: A
// - 80점 이상 ~ 89점 이하: B
// - 70점 이상 ~ 79점 이하: C
// - 60점 이상 ~ 69점 이하: D
// - 0점 이상 ~ 59점 이하: F
// - 그 외의 점수 (음수이거나 100점을 초과하는 경우): "올바르지 않은 점수입니다."" 출력
public class IfSolve {
    public static void main(String[] args) {
        int score = 101;
        if(score<=100 && score>=90) {
            System.out.println("A");
        } else if (score<90 && score>=80) {
            System.out.println("B");
        } else if (score<80 && score>=70) {
            System.out.println("C");
        } else if (score<70 && score>=60) {
            System.out.println("D");
        } else if (score<60 && score>=0) {
            System.out.println("F");
        } else {
            System.out.println("올바르지 않은 점수입니다");
        }
    }
}