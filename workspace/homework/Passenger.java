package homework;

public class Passenger {
    private String fareType; // 영유아, 어린이, 청소년, 성인, 노인
    private boolean card; //카드 사용 여부 (카드 : true, 현금 : false)
    private int fare; // 요금 ( age와 card에 의해 계산됨)
    private int distance; // 이동한 정류장 수
    private int distanceExtraCharge; // 정류장 수에 따른 추가 요금
    private int rideStation; // 승차한 정류장
    private int leaveStation; // 하차한 정류장

    public Passenger(String fareType, boolean card) {
        this.fareType = fareType;
        this.card = card;
    }


    public boolean isCard() {
        return card;
    }

    public void setCard(boolean card) {
        this.card = card;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public int getRideStation() {
        return rideStation;
    }

    public void setRideStation(int rideStation) {
        this.rideStation = rideStation;
    }

    public int getLeaveStation() {
        return leaveStation;
    }

    public void setLeaveStation(int leaveStation) {
        this.leaveStation = leaveStation;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistanceExtraCharge() {
        return distanceExtraCharge;
    }

    public void setDistanceExtraCharge (int distanceExtraCharge) {
        this.distanceExtraCharge = distanceExtraCharge;
    }

    public void calculateDistance(){
        this.distance = this.leaveStation - this.rideStation;
    }

    public String getFareType() {
        return fareType;
    }

    void cardDiscount(){
        if (card){ // 교통카드 사용시
            this.fare = this.fare * 9 / 10; // 10% 할인
            System.out.print("카드입니다. ");
        } else System.out.print("현금입니다. ");
    }
}
