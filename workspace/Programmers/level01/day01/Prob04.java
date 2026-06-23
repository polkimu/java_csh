package level01.day01;

import java.util.Scanner;

public class Prob04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = "";
        for(int i=0; i<a.length(); i++){
            if(Character.isUpperCase(a.charAt(i))){ // 대문자라면
                str += Character.toLowerCase(a.charAt(i)); // 소문자로 변환
            } else if(Character.isLowerCase(a.charAt(i))){ // 소문자라면
                str += Character.toUpperCase(a.charAt(i)); // 대문자로 변환
            }
        }

        System.out.println(str);
    }
}