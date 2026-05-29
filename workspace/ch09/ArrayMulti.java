package ch09;

public class ArrayMulti {
    public static void main(String[] args) {
        int[][] matrix2 = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        for(int i=0; i<matrix2.length; i++){
            for(int k=0; k<matrix2[i].length; k++){
                System.out.println(matrix2[i][k]);
            }
        }

        for (int[] numArray : matrix2) {
            for (int num : numArray) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
}
