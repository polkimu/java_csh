package ch12.mycar;

import java.util.Arrays;
import java.util.Objects;

public class Bus extends Car {
    private int passengerCount; //승객 수
    private String no;//버스 번호
    private String type; //광역버스, 시내버스 등
    private String[] stations; //버스 정차 역
    private int station; //현재 역 (stations 배열의 index)
    private int price; //버스 요금
    private int maxPassenger; //최대 승객 수
    private int money;
    private int totalPassenger;
    // 인스턴스 레벨이 아니라 클래스 레벨에서 관리하는 공용 변수
    private static int totalMoney;
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
    void ride(){
        if(passengerCount<maxPassenger) {
            passengerCount++; // 현재 승차 인원
            money += price; // 버스 1대의 수익
            totalPassenger++; // 전체 승객 수
            totalMoney += price; // 모든 버스의 총 수익

            System.out.println("1명이 승차합니다");
        }
        else{
            System.out.println("승차 인원이 초과되었습니다. 다음 버스를 타세요");
        }
    }

    //count만큼 승차 처리
    void ride(int count){
        for(int i=0; i<count; i++){
            ride();
        }
    }

    //하차
    void leave(){
        passengerCount--;
        System.out.println("1명이 하차합니다.");
    }

    //count만큼 하차
    void leave(int count){
        for(int i=0; i<count; i++){
            leave();
        }
    }

    void stop(){
        super.stop();
        station++;
        if(station == stations.length){
            station = 0;
        }
        System.out.println("이번 정류장은 " + stations[station] + " 입니다.");
    }

    @Override
    public String toString() {
        return "Bus{" +
                "passengerCount=" + passengerCount +
                ", no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", stations=" + Arrays.toString(stations) +
                ", station=" + station +
                ", price=" + price +
                ", maxPassenger=" + maxPassenger +
                ", money=" + money +
                ", totalPassenger=" + totalPassenger +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(no, bus.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerCount, no, type, Arrays.hashCode(stations), station, price, maxPassenger, money, totalPassenger);
    }
}
