package homework;

import java.util.Objects;

public class Bus extends Car {
    private int passengerCount; //승객 수
    private String no;//버스 번호
    private String type; //광역버스, 시내버스 등
    private String[] stations; //버스 정차 역
    private int station; //현재 역 (stations 배열의 index)
    private int price; //버스 요금
    private int maxPassenger; //최대 승객 수
    private int money; // 현재 까지의 수익
    private int totalPassenger; // 총 승차 인원
    private int totalMoney; // 운영하는 모든 버스의 수익
    //컴파일러에 의해 자동으로 생성되는 기본 생성자
    //Bus(){super();}


    public Bus(String name, String no, String type, String[] stations, int price, int maxPassenger) {
        super(name);
        this.no = no;
        this.type = type;
        this.stations = stations;
        this.price = price;
        this.maxPassenger = maxPassenger;
    }

    //승차
    //Passenger p를 입력받아서 p의 정보 입력  기본 요금을 p.fare에 저장
    void ride(Passenger p){
        // 수익 증가
        // 어린이 / 청소년 / 성인 / 노인별 할인율 적용해서 할인
        // 교통카드 / 현금 / 기타 할인 (지역 주민 할인, 특정 카드 이용시 할인)
        if(passengerCount < maxPassenger) {
            passengerCount++;
            p.setRideStation(station); // 탑승 정류장을 기록

            //요금 계산
            // 1. 나이에 따른 요금
            if(Objects.equals(p.getFareType(), "영유아")){ // 영유아
                p.setFare(0);// 무료
                p.cardDiscount();
                System.out.println(p.getFareType() + " 1명이 승차합니다. " +
                        "기본 요금은 " + p.getFare() + "원 입니다." );
            } else if(Objects.equals(p.getFareType(), "어린이")) { // 어린이
                p.setFare(price / 2); // 50% 할인
                p.cardDiscount();
                System.out.println( p.getFareType() + " 1명이 승차합니다. " +
                        "기본 요금은 " + p.getFare() + "원 입니다." );
            } else if(Objects.equals(p.getFareType(), "청소년")) { // 청소년
                p.setFare(price * 7/10); // 30% 할인
                p.cardDiscount();
                System.out.println(p.getFareType() + " 1명이 승차합니다. " +
                        "기본 요금은 " + p.getFare() + "원 입니다." );
            } else if(Objects.equals(p.getFareType(), "성인")){ // 성인 (할인 없음)
                p.setFare(price); // 정가
                p.cardDiscount();
                System.out.println(p.getFareType() + " 1명이 승차합니다. " +
                        "기본 요금은 " + p.getFare() + "원 입니다." );
            } else if(Objects.equals(p.getFareType(), "노인")){ //노인
                p.setFare(0); // 무료
                p.cardDiscount();
                System.out.println(p.getFareType() + " 1명이 승차합니다. " +
                        "기본 요금은 " + p.getFare() + "원 입니다." );
            }
        }else{
            System.out.println("승차 인원이 초과되었습니다. 다음 버스를 타세요.");
        }
    }

    //하차
    void leave(Passenger p){
        passengerCount--; // 버스 승차 인원 1 감소
        p.setLeaveStation(station); // 하차 정류장을 기록
        distanceExtraCharge(p); //거리에 따른 추가요금
        money += p.getFare(); //수익에 더함
        System.out.println("1명이 하차합니다. 거리에 따른 추가요금은 "
                + p.getDistanceExtraCharge() + "원 으로, 총 "
                + p.getFare() + "원이 결제되었습니다.");
    }

    void distanceExtraCharge(Passenger p){ // 거리에 따른 추가요금
        // distance : 승차 정류장에서 하차 정류장까지의 정류장 수
        p.calculateDistance(); // 하차 정류장 번호 - 승차 정류장 번호
        if (p.getDistance() < 0 && p.getDistance() > - stations.length){ //순환 후 하차했다면
            p.setDistance(stations.length);
            //1번 정류장 승차, 0번 정류장 하차했다면 : 1->2->0 distance=2
        }
        // 이동한 정류장 하나당 10% 추가요금
        p.setDistanceExtraCharge(( p.getFare() * p.getDistance() ) /10);
        p.setFare(p.getFare() + p.getDistanceExtraCharge()); // 기본요금 + 추가요금
    }

    void stop(){
        super.stop();
        station++;
        if(station == stations.length){
            station = 0;
        }
        System.out.println("이번 정류장은 " + stations[station] + " 입니다.");
    }


    //버스의 현재 상태 출력
    String getBusInfo(){
        return "버스 번호 : " + no
                +", 종류 : " + type
                + ", 현재 위치 : " + stations[station]
                + ", 남은 좌석 : " + (maxPassenger - passengerCount)
                + ", 요금 : " + price
                + ", 총 수익 : " + money;
    }
}
