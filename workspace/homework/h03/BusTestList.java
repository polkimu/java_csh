package h03;

import java.util.ArrayList;
import java.util.Scanner;

public class BusTestList {
    public static void main(String[] args) {
        //Car 인스턴스를 생성한다
        //인스턴스를 생성할 때 사용한 클래스가 생성한 인스턴스의 타입이 된다
        Bus bus1 = new Bus("람보르기니", "10-2", "마을버스",
                new String[]{"우리 집", "김포고등학교", "김포 시청"},
                1300, 15);

        ArrayList<Passenger> plist = new ArrayList<>(); // 승객들을 리스트로 저장
        ArrayList<Bus> blist = new ArrayList<>();
        int ridePassengerIndex = 0; // 몇번째 탑승객인지 저장, 첫번째 승객 : 0번
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("현재 버스의 속도는 " + bus1.speed + "입니다. 다음 행동을 선택해 주십시오" );
            System.out.println("1.가속 2.정차 3.버스 정보 확인");
            int toDo = s.nextInt();
            switch (toDo){
                case 1 -> bus1.speedUp(); // 가속
                case 2 -> { // 정지 -> 승차 -> 하차
                    bus1.stop(); // 1. 정지
                    //2. 승차
                    int numRidePassenger = howManyRide(); // 몇명이 탑승?
                    for (int i = 0; i < numRidePassenger; i++) {// 탑승객 숫자만큼 반복
                        System.out.println((ridePassengerIndex+1) + "번째 승객입니다.");
                        String type = sortPassengerType(); // 영유아 or 어린이 or 청소년 or 성인 or 노인
                        boolean isCard = cashOrCard();//
                        p[ridePassengerIndex] = new Passenger(type, isCard);
                        bus1.ride(p[ridePassengerIndex]);
                        ridePassengerIndex++;
                    }

                    //하차
                    int numLeavePassenger = howManyLeave();
                    for(int i=0; i<numLeavePassenger; i++){
                        int leavePassengerIndex;
                        leavePassengerIndex = whichIndexLeave();
                        bus1.leave(p[leavePassengerIndex-1]);
                        p[leavePassengerIndex-1] = null;
                    }
                }
                case 3 -> {
                    System.out.println(bus1.getBusInfo());
                }
            }

        }
    }

    static int howManyRide(){
        System.out.println("탑승할 승객이 몇명 있나요? 입력 예시 : 3");
        Scanner s = new Scanner(System.in);
        int numPassenger;
        numPassenger = s.nextInt();
        return numPassenger;
    }

    static int howManyLeave(){
        System.out.println("하차할 승객이 몇명 있나요? 입력 예시 : 3");
        Scanner s = new Scanner(System.in);
        int numPassenger;
        numPassenger = s.nextInt();
        return numPassenger;
    }

    static int whichIndexLeave(){
        System.out.println("몇번째 승객이 내립니까?");
        Scanner s = new Scanner(System.in);
        int passengerIndex;
        passengerIndex = s.nextInt();
        return passengerIndex;
    }

    static String sortPassengerType() {
        String fareType = null; // 연령별 구분 (영유아, 어린이, 청소년, 성인, 노인)
        boolean isCard = false; // 카드인가?
        System.out.println("승객을 태웁니다");
        System.out.println("1.영유아 2.어린이 3.청소년 4.성인 5.노인");
        Scanner s = new Scanner(System.in);
        int type = s.nextInt();
        switch (type) {
            case 1 -> fareType = "영유아";
            case 2 -> fareType = "어린이";
            case 3 -> fareType = "청소년";
            case 4 -> fareType = "성인";
            case 5 -> fareType = "노인";
        }
        System.out.println(fareType);
        return fareType;
    }

    static boolean cashOrCard(){ // 지불 방식 (현금 혹은 카드)
        System.out.println("1.현금 2.카드");
        Scanner s = new Scanner(System.in);
        int card = s.nextInt();
        if (card == 1) {
            System.out.println("현금입니다.");
            return false;
        }
        if (card == 2) {
            System.out.println("카드는 10% 할인됩니다.");
            return true; // default = false
        }
        else return false;
    }
}
