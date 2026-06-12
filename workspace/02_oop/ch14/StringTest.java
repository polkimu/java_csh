package ch14;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1 == "Hello");
        System.out.println(s2 == "Hello");
        //실제 값이 아닌 주소를 비교

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals("Hello"));
        System.out.println(s2.equals("Hello"));
        //실제 값을 비교

        s1 += " World";
        s1 += " Java";
        s1 += " Program"; // heap 메모리 영역에 String 객체가 계속해서 생성됨 (String객체는 불변하기 때문)

        System.out.println(s1);
    }
}
