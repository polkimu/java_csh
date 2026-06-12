package ch09;

public class EnhancedFor {
    public static void main(String[] args) {
        //int[] scores = {90, 80, 75}; // 3과목
        int[] scores = {100, 80, 70, 88};

        int[][] matrix2 = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        int sum = 0;
        double avg=0.0;
        //과목수에 상관없이 총점과 평균을 계산
//        for(int i=0; i<scores.length; i++) {
//            sum += scores[i];
//        }
        //Enhanced for loop
//        for (int score : scores){
//            sum += score;
//        }
//        avg = (double)sum / scores.length;
//
//        System.out.println("총점 : " + sum);
//        System.out.println("평균 : " + avg);

        for(int[] numArray : matrix2){
            for (int num : numArray) {
                System.out.println(num);
            }
        }
    }
}
