package ch12.family.ex01;

public class Son {
    String name;

    //생성자 : 클래서 명과 동일한 이름, 리턴 타입 없음
    Son(String name){
        this.name = name;
    }

    void eat(){
        System.out.println(name + " : 음식을 맛있게 먹는다");
    }

    void play()
    {
        System.out.println(name + " : 게임을 한다");
    }

    void sleep()
    {
        System.out.println(name + " : 꿀잠을 잔다");
    }
}
