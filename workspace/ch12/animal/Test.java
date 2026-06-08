package ch12.animal;

public class Test {
    public static void main(String[] args) {
//        Dog haru = new Dog();
        Animal Haru = new Dog(); // 자식을 부모로 바꾸는 것을 업캐스팅 (묵시적 형변환)
                                 // 부모를 자식으로 바꾸는 것을 다운 캐스팅 (명시적 형변환)
//        haru.eat();
//        haru.bark();
//
//        animalCare(haru);

        //잘못된 상속
//        Notebook book = new Notebook();
//        animalCare(book);

        Cat c = new Cat();
        animalCare(c);
    }

    //동물 관리 서비스
    static void animalCare(Animal a){
        a.eat(); // 오버라이딩 된 메서드가 출력
        a.sleep();
        a.move();
    }

    static void animalCare(Cat a){
        a.eat();
        a.sleep();
        a.move();
        a.liquefy();//Animal에는 정의되어있지 않음
    }
}
