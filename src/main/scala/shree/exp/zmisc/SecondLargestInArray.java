package shree.exp.zmisc;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/6/17.
 */
public class SecondLargestInArray {

    public static void main(String[] args) {
        int[] input = {21,34,78,54,56,32,10};

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if(input[i] > first) {
                second = first;
                first = input[i];
            }
        }

        System.out.println(first+" | "+second);

        int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            if(input[i] < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = input[i];
            }
        }

        System.out.println(firstSmall+" | "+secondSmall);

    }
}
