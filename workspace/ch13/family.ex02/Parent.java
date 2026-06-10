package ch13.family.ex02;

//상속 클래스, instanceof 사용
//추상 클래스 사용

//추상클래스는
//1. 직접 객체 생성 불가
//2. 추상 메서드가 하나라도 있다면 반드시 추상 클래스로 선언
public abstract class Parent {
    String name;

    //생성자 : 클래스 명과 동일한 이름, 리턴 타입 없음
    Parent(String name){
        this.name = name;
    }

    void eat(){
        System.out.println(name + " : 음식을 맛있게 먹는다");
    }

    void play(){
        System.out.println(name + " : 등산한다");
    }

    void sleep(){
        System.out.println(name + " : 꿀잠을 잔다");
    }

    //부모 관점에서는 구현할 내용 없음
    //자식이 오버라이드 해서 구현하기를 원함
    abstract void study();
}
