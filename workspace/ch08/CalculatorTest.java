package ch08;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("계산식을 입력하시오");
        Scanner s = new Scanner(System.in);
        double num1 = s.nextDouble();
        String operator = s.next();
        double num2 = s.nextDouble();

        String result = switch (operator){
            case "+" -> num1 + operator + num2 + "=" +(num1 + num2);
            case "-" -> num1 + operator + num2 + "=" +(num1 - num2);
            case "*" -> num1 + operator + num2 + "=" +(num1 * num2);
            case "/" -> num1 + operator + num2 + "=" +(num1 / num2);
            default -> "수식에 오류가 있습니다";
        };
        System.out.println(result);
    }
}
