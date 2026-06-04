package ch11.statictest;

public class MainMethodTest {

    public void instanceMethod(){
        System.out.println("인스턴스 메서드 호출");
    }

    public static void staticMethod(){
        System.out.println("static 메서드 호출");
    }

    //Java 21 이전
    public static void main(String[] args) {
        //main 메서드에서 외부 메서드를 호출하는 방법 1
        //static 메서드를 그냥 호출
        staticMethod();

        //방법 2
        //instance 생성 후 호출
        MainMethodTest m = new MainMethodTest();
        m.instanceMethod();
    }

    //자바 21 이후
    void main() {
        //main 메서드에서 외부 메서드를 호출하는 방법 1
        //static 메서드를 그냥 호출
        staticMethod();

        //방법 2
        //instance 생성 후 호출
        instanceMethod();
    }
}
