package blah.just.practice;

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 0, 0, 0, 2, 2, 2, 1, 1, 0,1, 0,2};

        int a = 0, b = 0, c = array.length - 1;

        while(b <= c) {
            if(array[b] == 0) {
                swap(array, a, b);
                a++; b++;
            } else if (array[b] == 1) {
                b++;
            } else if(array[b] == 2) {
                swap(array, c, b);
                c--;
            }
        }

        print(array);
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
