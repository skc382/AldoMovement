package shree.exp;

import scala.Array;
import scala.Int;
import scala.math.Ordering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/7/17.
 */
public class Utils {

    public static void printArray(List<Integer> arrayList) {
        int[] arr = arrayList.stream().mapToInt(x -> x).toArray();
        printArray(arr);
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }

    public static void printArray(char[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static String swap(String array, int i, int j) {
        char[] value = array.toCharArray();
        swap(value, i, j);
        return String.valueOf(value);
    }

    public static void initializeMatrix(char[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void initializArray(int[] matrix, int value) {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = value;
        }
    }

    public static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < matrix.length - 1) {
                    System.out.print(matrix[i][j] + ", ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < matrix.length - 1) {
                    System.out.print(matrix[i][j] + ", ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < matrix[0].length - 1) {
                    System.out.print(matrix[i][j] + ", ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrixWithHeadings(char[] rowHeadings, char[] columnHeadings, int[][] matrix) {
        Character[] rowHeadingsCh = new Character[rowHeadings.length];
        Character[] columnHeadingsCh = new Character[columnHeadings.length];

        for (int i = 0; i < rowHeadings.length; i++) {
            rowHeadingsCh[i] = rowHeadings[i];
        }

        for (int i = 0; i < columnHeadings.length; i++) {
            columnHeadingsCh[i] = columnHeadings[i];
        }
        printMatrixWithHeadings(rowHeadingsCh, columnHeadingsCh, matrix);
    }
    public static void printMatrixWithHeadings(Character[] rowHeadings, Character[] columnHeadings, int[][] matrix) {
        String[][] matrixWitHeadings = new String[matrix.length][matrix[0].length];

        if(rowHeadings.length != matrix.length) {
            throw new RuntimeException("RowHeadings length doesn't match the matrix");
        }

        if(columnHeadings.length != matrix[0].length) {
            throw new RuntimeException("ColumnHeadings length doesn't match the matrix");
        }

        for (int i = 0; i < matrixWitHeadings.length; i++) {
            matrixWitHeadings[i][0] = String.valueOf(rowHeadings[i]);
        }

        for (int i = 0; i < matrixWitHeadings[0].length; i++) {
            matrixWitHeadings[0][i] = String.valueOf(columnHeadings[i]);
        }

        String DOUBLE_SPACE = "  ";
        String SINGLE_SPACE = " ";
        String SINGLE_SPACE_SEPERATOR = " | ";
        String DOUBLE_UNDERSCORE = "___";

        System.out.print(DOUBLE_SPACE + DOUBLE_SPACE);
        for (int i = 0; i < rowHeadings.length; i++) {
            System.out.print(columnHeadings[i] + DOUBLE_SPACE);
        }
        System.out.println();

        System.out.print(SINGLE_SPACE + DOUBLE_SPACE);
        for (int i = 0; i < rowHeadings.length; i++) {
            System.out.print(DOUBLE_UNDERSCORE);
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = -1; j < matrix[0].length; j++) {
                if(j == -1) {
                    System.out.print(rowHeadings[i] + SINGLE_SPACE_SEPERATOR);
                } else {
                    System.out.print(matrix[i][j] + DOUBLE_SPACE);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //Some code
    }
}
