package homework;

public class CarTest {
    public static void main(String[] args) {
        //Car 인스턴스를 생성한다
        //인스턴스를 생성할 때 사용한 클래스가 생성한 인스턴스의 타입이 된다
        Car mycar = new Car("람보르기니");
        mycar.speed = 100;
        mycar.start();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.stop();
    }
}
