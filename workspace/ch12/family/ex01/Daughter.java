package ch12.family.ex01;

public class Daughter {
    String name;

    //생성자 : 클래서 명과 동일한 이름, 리턴 타입 없음
    Daughter(String name){
        this.name = name;
    }

    void eat(){
        System.out.println(name + " : 음식을 맛있게 먹는다");
    }

    void play(){
        System.out.println(name + " : 코노에 간다");
    }

    void sleep(){
        System.out.println(name + " : 꿀잠을 잔다");
    }
}
