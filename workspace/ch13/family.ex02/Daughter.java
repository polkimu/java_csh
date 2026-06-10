package ch13.family.ex02;

//추상클래스를 상속 받는 자식 클래스는
//1. 추상 메서드를 모두 구현하거나
//2. 구현하지 못한 추상 메서드가 하나라도 남아있다면 자신도 추상클래스가 되어야 함
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

    public void study(){
        System.out.println(name + " : 과외를 받는다");
    }
}
