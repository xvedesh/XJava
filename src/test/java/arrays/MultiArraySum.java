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
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                columnSum += matrix[i][j];
            }
            res[arrIndex + j] = columnSum;
            columnSum = 0;
        }
        return res;
    }

    public static int[] biggestInt(int[][] matrix) {
        int max;
        int[] res = new int[3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j - 1] < matrix[i][j]) {
                    max = matrix[i][j];
                    res[0] = max;
                    res[1] = i;
                    res[2] = j;
                }
            }
        }
        return res;
    }

    public static int[][] matrixProduct(int[][] m1, int[][] m2) {
        if (m1[0].length != m2.length) {
            System.out.println("the matrices sum is not possible");
            return new int[][] {{0}, {0}};
        }
        int[][] newM = new int[m1.length][m1[0].length];
        int newMatrixIndex = 0;
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                newM[i][newMatrixIndex] += (m1[i][j] * m2[j][i]);
            }
            newMatrixIndex++;
            if(newMatrixIndex < m2.length)
                i--;
            if(newMatrixIndex == m2.length) {
                newMatrixIndex = 0;
            }
        }
        return newM;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {1, 5, 3}};
        int[][] matrix2 = {{1, 2, 3}, {1, 2, 3}, {3, 7, 1}};
        System.out.println(sumArray(matrix));
        System.out.println(Arrays.toString(rowColSum(matrix)));
        System.out.println(Arrays.toString(biggestInt(matrix)));
        int[][] res = matrixProduct(matrix, matrix2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
