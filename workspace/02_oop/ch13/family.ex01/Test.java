package ch13.family.ex01;

public class Test {
    public static void main(String[] args) {
//        Parent p = new Parent("부모");
//        Parent p = new Son("아들"); // up casting(자동 형변환)
        Daughter p = new Daughter("딸");
        dailySchedule(p);
    }

    //하루 일과
    private static void dailySchedule(Parent p){
        p.eat();
        p.play();
        if(p instanceof Son){
            Son s = (Son) p;
            s.study();
        }
        p.sleep();
    }

    private static void dailySchedule(Son p){
        p.eat();
        p.play();
        p.sleep();
    }

//    private static void dailySchedule(Daughter p){
//        p.eat();
//        p.play();
//        p.sleep();
//    }
}
