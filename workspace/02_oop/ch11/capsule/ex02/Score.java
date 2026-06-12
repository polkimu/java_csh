package ch11.capsule.ex02;

public class Score {
    private int kor;
    private int eng;
    private int math;

    public Score(int kor, int eng) {
        this.kor = kor;
        this.eng = eng;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getMath(){
        return this.math;
    }
    public void setMath(int math){
        this.math = math;
    }

    Score(int kor, int eng, int math) {
        if(kor > 100 || kor < 0){
            System.out.println("kor값은 0 ~ 100 사이로 입력해야 합니다.");
            return;
        }
        if(eng > 100 || eng < 0){
            System.out.println("eng값은 0 ~ 100 사이로 입력해야 합니다.");
            return;
        }
        if(math > 100 || math < 0){
            System.out.println("math값은 0 ~ 100 사이로 입력해야 합니다.");
            return;
        }
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
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
