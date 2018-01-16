package shree.exp;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/7/17.
 */
public class Utils {

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if(i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }

    public static void printArray(char[] array) {

        for (int i = 0; i < array.length; i++) {
            if(i < array.length - 1) {
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

        for (int i = 0; i < matrix[0].length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j < matrix.length - 1) {
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

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j < matrix[0].length - 1) {
                    System.out.print(matrix[i][j] + ", ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Some code
    }
}
