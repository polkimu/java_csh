package ch08;

public class ForTest2 {
    public static void main(String[] args) {
        long sal = 1; //변수명

        for(int month = 1; month < 36; month++) { //1~35
            System.out.println(month + "달의 급여" + sal);
            sal *= 2;
        }
        System.out.println("3년째의 급여"+sal);
    }
}
