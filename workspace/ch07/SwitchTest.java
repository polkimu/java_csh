package ch07;

public class SwitchTest {
    static void main(String[] args) {
        int month = 5;
        if(month < 1 || month > 12) {
            System.out.println("1~12까지의 숫자를 입력해야 합니다");
        }
        if (month == 1) {
            System.out.println("1월의 마지막 날은 31일 입니다.");
        } else if (month == 2) {
            System.out.println("2월의 마지막 날은 28일 입니다.");
        } else if (month == 3) {
            System.out.println("3월의 마지막 날은 31일 입니다.");
        } else if (month == 4) {
            System.out.println("4월의 마지막 날은 30일 입니다.");
        } else if (month == 5) {
            System.out.println("5월의 마지막 날은 31일 입니다.");
        } else if (month == 6) {
            System.out.println("6월의 마지막 날은 30일 입니다.");
        } else if (month == 7) {
            System.out.println("7월의 마지막 날은 31일 입니다.");
        } else if (month == 8) {
            System.out.println("8월의 마지막 날은 31일 입니다.");
        } else if (month == 9) {
            System.out.println("9월의 마지막 날은 30일 입니다.");
        } else if (month == 10) {
            System.out.println("10월의 마지막 날은 31일 입니다.");
        } else if (month == 11) {
            System.out.println("11월의 마지막 날은 30일 입니다.");
        } else if (month == 12) {
            System.out.println("12월의 마지막 날은 31일 입니다.");
        }
    }
}
