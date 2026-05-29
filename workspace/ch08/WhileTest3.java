package ch08;

//6이 나올 때 까지 주사위 던지기
public class WhileTest3 {
    public static void main(String[] args) {
        int testCount = 0;
        while(testCount<100){
            int num = 0;
            int count = 0;
            // Math.random() : 0이상 1미만 double 타입의 숫자를 반환

            while(num != 600) {
                num = (int) (Math.random()*600); // 0이상 6미만
                num++; // 1~6
                //System.out.println(num);
                count++;
            }

            System.out.println("반복 횟수: " + count);
            testCount++;
        }

    }
}
