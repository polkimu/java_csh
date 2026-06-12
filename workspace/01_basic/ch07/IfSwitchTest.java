package ch07;

// 나이에 따른 입장료 할인
// 7세 이하 : 100% 할인
// 8 ~ 13 : 50% 할인
// 14 ~ 19 : 30% 할인
// 65세 이상 : 70% 할인
public class IfSwitchTest {
    public static void main(String[] args) {
        int price = 20000;
        double discountRate = 0.0;
        int age = 15;
        int lastprice = price;

        if(age<8){
            discountRate = 1.0;
        } else if(age>=8 && age <14) {
            discountRate = 0.5;
        } else if (age>=14 && age <20) {
            discountRate = 0.3;
        } else if (age>=65) {
            discountRate = 0.7;
        } else {
            discountRate = 0.0;
        }
        lastprice = (int) (price * (1-discountRate));
        System.out.println("나이가 "+ age +"세 이므로 할인율 "+ discountRate * 100 +"%가 적용되어 요금은 "+ lastprice +"원 입니다.");
    }
}
