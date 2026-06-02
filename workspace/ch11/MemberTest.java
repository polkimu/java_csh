package ch11;

public class MemberTest {
    String id;

    //생성자 정의
    MemberTest(String id){
        this.id = id;
    }
    static void main(String[] args) {
        MemberTest member = new MemberTest("yong");
        System.out.println("회원 아이디: " + member.id);
    }
}
