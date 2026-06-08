package ch12.car;

public class Bus extends Car{
    private int passengerCount; //승객 수
    private String no;//버스 번호
    private String type; //광역버스, 시내버스 등
    private String[] stations; //버스 정차 역
    private int station; //현재 역 (stations 배열의 index)
    private int price; //버스 요금
    private int maxPassenger; //최대 승객 수
    private int money;
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
            passengerCount++;
            System.out.println("1명이 승차합니다");
        }
        else{
            System.out.println("승차 인원이 초과되었습니다. 다음 버스를 타세요");
        }
    }

    //하차
    void leave(){
        passengerCount--;
        System.out.println("1명이 하차합니다.");
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
                + ", 요금 : " + price;
    }
}
