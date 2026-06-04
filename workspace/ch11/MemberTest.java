package ch11;

public class MemberTest {
    String id; //멤버 변수

    //생성자 정의
    MemberTest(String id){ //2 id = yong{
        this.id = id; //yong //3
    }

    static void main(String[] args) {
        MemberTest member = new MemberTest("yong"); // 1
        System.out.println("회원 아이디: " + member.id); // 4
    }
}
