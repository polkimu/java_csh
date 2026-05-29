package ch08;

//구구단
/*
2 x 1 ... 9 x 1
2 x 2 ... 9 x 2
...       ...
2 x 9     9 x 9
 */
public class ForTest6 {
    public static void main(String[] args) {
        for(int i=1; i<=9; i++){
            for(int k=2; k<=9; k++){
                System.out.print(k + "x" + i + "=" + k*i + "\t");
            }
            System.out.println();
        }
    }
}
