package ch08;

import java.util.Scanner;

public class ForTest4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dan = s.nextInt();
        System.out.println(dan);
        for(int i = 1; i <= 9; i++){
            System.out.println(dan + "*" + i + "=" + dan * i);
        }
    }
}
