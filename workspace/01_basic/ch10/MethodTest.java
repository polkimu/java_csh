package ch10;

public class MethodTest {
    void main(String[] args) {
        add();
        add100(10); // Arguments(인자, 인수)
        printSum(40,50);

        int result = getSum(70, 80);
        System.out.println(result);
    }

    // 10과 100의 합계 출력
    void add(){
        int n1 = 10;
        int n2 = 100;
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    //전달되는 인자와 100을 더함
    void add100(int n1){
        int n2 = 100;
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    //전달되는 인자 두개의 합계를 출력
    void printSum(int n1, int n2){
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    //전달되는 인자 두개의 합계를 반환
    int getSum(int n1, int n2){
        int sum = n1 + n2;
        return sum;
    }
}
