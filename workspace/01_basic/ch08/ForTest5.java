package ch08;

public class ForTest5 {
    public static void main(String[] args) {
        //star1();
        //star2();
        //star3();
        star4();
    }

    /*
    *
    **
    ***
    ****
    *****
    */
    static void star1(){
        for (int i=0; i<1; i++) {
            System.out.print("*");
        }
        System.out.println();
        for(int i=0; i<2; i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=0; i<3; i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=0; i<4; i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=0; i<5; i++){
            System.out.print("*");
        }
        System.out.println();
    }

    // 중첩
    /*
    *
    **
    ***
    ****
    *****
    *    */
    static void star2(){
        for(int i=0; i<5; i++){ // i = 0 i = 1 i = 2
            for(int k=0; k<i+1; k++){ // k<1 k=0, k=1 x // k<2 k=0 k=1 k=2 x // k<3 k=0 k=1 k=2 k=3 x
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    ***** i = 0 k < 5
    **** i = 1, k < 4
    *** i =2 k < 3
    **
    *
     */
    static void star3(){
        for(int i=0; i<5; i++){
            for(int k=0; k<5-i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /*
        *
       **
      ***
     ****
    *****
     */
    static void star4(){
        for(int i=0; i<5; i++){
            for(int k=0; k<4-i; k++){
                System.out.print(" ");
            } // space
            for(int k=0; k<i+1; k++){
                System.out.print("*");
            } // star
            System.out.println();
        }
    }
}
