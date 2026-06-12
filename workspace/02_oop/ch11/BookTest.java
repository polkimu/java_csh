package ch11;

//public class는 하나에만 지정 가능

class Book{
    String title;
    String author;
    //필드


    //생성자 작성
    Book( ){
        this("제목 미상", "작가 미상");
    }
    //생성자 작성
    Book(String title, String author){ // 매개 변수{
        this.title=title;
        this.author=author;
    }
}

public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book(); //지역변수
        book1.title = "자바 기초";
        book1.author = "자바의신";

        Book book2 = new Book("자바를 자바라!", "용쌤");

        System.out.println("제목 : " + book1.title + ", 작가 : " + book1.author);
        System.out.println("제목 : " + book2.title + ", 작가 : " + book2.author);
    }
}

