package ch11.statictest;

public class MathUtil {
    final static double PI = 3.141459; // final로 선언하면 상수 (읽기 전용, 수정 불가)
    static int r = 5; //인스턴스 필드

    static void area(){
        //static 메서드에서는 static 필드, 메서드만 사용 가능
        System.out.println(PI*r*r);
    }

    //메서드 내부에서 인스턴스 필드나 인스턴스 메서드를 사용하지 않을 경우에 static을 붙이면 된다.
    //static 필드와 인스턴스 필드로 나뉘고, static 메서드와 인스턴스 메서드로 나뉨
    static int add(int n1, int n2){
        return n1 + n2;
    }
}
