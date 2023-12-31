package arrays;

import java.util.Arrays;

public class MultiArraySum {

    public static int sumArray(int[][]matrix) {
        if(matrix.length == 1 && matrix[0].length == 1)
            return matrix[0][0];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int[] rowColSum(int[][]matrix) {
        int[] res = new int[matrix.length + matrix[0].length];
        int rowSum = 0;
        int columnSum = 0;
        int arrIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            res[i] = rowSum;
            arrIndex++;
            rowSum = 0;
        }
        for (int j = 0; j < matrix[j].length; j++) {
            for (int i = j; i < matrix.length; i++) {
                columnSum += matrix[i][j];
            }
            res[arrIndex + j] = columnSum;
            columnSum = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {1, 2, 3}};
        System.out.println(sumArray(matrix));
        System.out.println(Arrays.toString(rowColSum(matrix)));
    }
}
