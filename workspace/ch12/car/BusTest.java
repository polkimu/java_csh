package ch12.car;

public class BusTest {
    public static void main(String[] args) {
        //Car 인스턴스를 생성한다
        //인스턴스를 생성할 때 사용한 클래스가 생성한 인스턴스의 타입이 된다
        Bus mycar = new Bus("람보르기니", "10-2", "마을버스",
                new String[]{"우리 집", "김포고등학교", "김포 시청"},
                1300, 15);

        mycar.ride();
        mycar.ride();
        mycar.start();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.stop();
        mycar.ride();
        mycar.leave();
        System.out.println(mycar.getBusInfo());
    }
}
