package ch07;

public class SwitchTest2 {
    static void main(String[] args) {
        char grade = 'C';
        int price = 10000;
        int lastprice = price;
        int discountRate = 0;

        if(grade == 'A') {
            discountRate = 50;
        }
        else if(grade == 'B') {
            discountRate = 30;
        }
        else if(grade == 'C') {
            discountRate = 10;
        }
        else if(grade == 'D') {
            discountRate = 0;
        }
        lastprice = (int)(price * (1.0 - discountRate/100.0));
        System.out.println(lastprice);
    }
}
