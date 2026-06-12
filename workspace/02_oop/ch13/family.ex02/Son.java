package ch13.family.ex02;

//Son이 Parent의 필드와 메스드를 상속받는다
public class Son extends Parent {
    //생성자 : 클래서 명과 동일한 이름, 리턴 타입 없음
    Son(String name){
        super(name); // 부모의 생성자
    }

    void play(){
        work();
        System.out.println(name + " : 게임을 한다");
    }

    private void work(){
        System.out.println(name + " : 일한다");
    }

    public void study(){
        System.out.println(name + " : 도서관에서 공부한다.");
    }
}
