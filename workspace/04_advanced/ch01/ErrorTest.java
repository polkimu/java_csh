package ch01;

public class ErrorTest {
    public static void main(String[] args){
        try {
            int result = 10 / 0;
            System.out.println("result : " + result);
        } catch (ArithmeticException e) {
            System.out.println("에러 발생" + e.getMessage());
        }

        try{
            makeError();
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("에러 발생 : " + t.getClass().getSimpleName());
        }
        System.out.println("시스템 종료");
    }

    static void makeError(){
        makeError();
    }
}
