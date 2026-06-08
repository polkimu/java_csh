package ch12.mycar;

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

        Bus mycar2 = new Bus("전기버스", "10-3", "광역 버스",
                new String[]{"김포 시청", "발산역", "홍대역", "서울 시청"},
                1300, 15);

        mycar2.ride(3);
        mycar2.ride(5);
        mycar2.start();
        mycar2.speedUp();
        mycar2.speedUp();
        mycar2.speedUp();
        mycar2.speedUp();
        mycar2.speedUp();
        mycar2.stop();
        mycar2.ride();
        mycar2.leave(4);

        System.out.println(mycar.toString());
        System.out.println(mycar2.toString());

        System.out.println(mycar.equals(mycar2));
    }
}
