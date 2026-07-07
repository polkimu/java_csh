package ch06.lambda;

public class LambdaTest {

    void test1(){
        //Inner Class
        class CalculatorImpl implements Calculator{
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        }
        Calculator call = new CalculatorImpl();
        System.out.println(call.add(10, 20));
    }

    // 익명 클래스로 클래스 선언과 동시에 객체 생성
    void test2(){
        Calculator call = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };
        System.out.println(call.add(30, 40));
    }

    // 람다식 사용
    void test3(){
        int defaultVal = 10;
        Calculator call = (int a, int b) -> a + b + defaultVal;
        System.out.println(call.add(50, 60));
    }
    void main(){
        test1();
        test2();
        test3();
    }
}
