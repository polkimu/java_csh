package ch13.family.ex01;

public class Daughter extends Parent {

    //생성자 : 클래서 명과 동일한 이름, 리턴 타입 없음
    Daughter(String name){
        super(name);
    }

    void play(){
        System.out.println(name + " : 코노에 간다");
        doFaceMask();
    }

    private void doFaceMask(){
        System.out.println(name + " : 마스크 팩을 한다");
    }
}
